import {useEffect, useRef, useState} from "react";
import axios from "axios";
import {useLocation} from "react-router-dom";
import Review from "./Review";
import Info from "./Info";
import Notice from "./Notice";
import PageNavigation from "../list/PageNavigation";
import {API_BASE_URL} from "../../../App";

function View() {
    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);
    const prodNo = searchParams.get('prodNo');


    //ProductDTO 받아오기
    let [prodDTO, setProdDTO] = useState({
        prodNo: prodNo,
        bizType: '',
        company: '',
        delivery: '',
        descript: '',
        detail: '',
        discount: '',
        duty: '',
        etc1: '',
        etc2: '',
        etc3: '',
        etc4: '',
        etc5: '',
        hit: '',
        ip: '',
        origin: '',
        point: '',
        price: '',
        prodCate1: '',
        prodCate2: '',
        prodName: '',
        rdate: '',
        receipt: '',
        review: '',
        score: '',
        seller: '',
        sold: '',
        status: '',
        stock: '',
        thumb1: '',
        thumb2: '',
        thumb3: ''
    });
    //페이징 변수 선언
    let [pageRequestDTO, setPageRequestDTO] = useState({
        pg: 1, size: 5, prodNo: prodNo
    })
    let [pageResponseDTO, setPageResponseDTO] = useState({
        prodNo: parseInt(prodNo),
        reviewDtoList: [],
        end: 10,
        start: 1,
        next: true,
        prev: true,
        total: 10,
        size: 5,
        pg: 1
    });

    //prodDTO, reviewList 가져옴
    useEffect(() => {
        if (prodDTO.company === '') {
            axios.get(`${API_BASE_URL}/product/view`, {
                params: {prodNo}
            })
                .then(res => {
                    setProdDTO(res.data)
                }).catch(error => {
                console.log(error);
            })
        }

        axios.get(`${API_BASE_URL}/product/view/review`, {
            params: pageRequestDTO
        })
            .then(res => {
                setPageResponseDTO(res.data)
            }).catch(error => {
            console.log(error);
        })

    }, [pageRequestDTO, prodDTO]);
    const changeProdDTO = (key, value) => {
        setProdDTO((ProdDTO) => {
            let newProdDTO = {...prodDTO};
            newProdDTO[key] = value;
            return newProdDTO;
        });
    };

    const changePageRequest = (key, value) => {
        setPageRequestDTO((pageRequestDTO) => {
            let pageRequest = {...pageRequestDTO};
            pageRequest[key] = value;
            return pageRequest;
        });
    };
    //상품평 보기 스크롤
    const divRef = useRef(null);
    const [divYPosition, setDivYPosition] = useState(null);

    useEffect(() => {
        // div 요소의 Y축 위치 확인
        if (divRef.current) {
            const rect = divRef.current.getBoundingClientRect();
            const yPosition = rect.top + window.scrollY; // 윈도우 스크롤을 고려한 위치
            setDivYPosition(yPosition);
        }
    }, []);


    if (prodDTO.company !== '') {
        return <>
            <Info prodDTO={prodDTO} scrollY={divYPosition} changeProdDTO={changeProdDTO}></Info>


            <Detail prodDTO={prodDTO}></Detail>
            <Notice prodDTO={prodDTO}></Notice>

            <article className="review">
                <nav>
                    <h1 ref={divRef}>상품리뷰</h1>
                </nav>

                <Review pageResponseDTO={pageResponseDTO}></Review>

                <PageNavigation pageResponseDTO={pageResponseDTO} changePageRequest={changePageRequest}>

                </PageNavigation>

            </article>

        </>
    }
}

function Detail({prodDTO}) {
    return <article className="detail">
        <nav>
            <h1>상품정보</h1>
        </nav>
        <img src={`${process.env.REACT_APP_HOME_URL}/images/thumbs/${prodDTO.detail}`} style={{width:'860px', height:'460px', objectFit:'fill'}} alt="detail"/>
    </article>
}

export default View;