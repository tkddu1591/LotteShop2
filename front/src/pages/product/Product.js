import {useEffect, useState} from "react";
import axios from "axios";
import {Route, Routes, useLocation} from "react-router-dom";
import ProductItem from "./list/ProductItem"
import PageNavigation from "./list/PageNavigation";
import CateRoot from "./CateRoot";

function List() {
    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);
    const newCate = searchParams.get('cate');
    const [cate, setCate] = useState(newCate);
    const newSearch = searchParams.get('search');
    const [search, setSearch] = useState(newSearch);
    const newType = searchParams.get('type');
    const [type, setType] = useState(newType);

    let [pageRequestDTO, setPageRequestDTO] = useState({
        pg: 1, size: 10, cate: cate, search: search, type: type
    })
    let [pageResponseDTO, setPageResponseDTO] = useState({
        cate: parseInt(cate), dtoList: [], end: 10, start: 1, next: true, prev: true, total: 10, size: 10
    });

    useEffect(() => {
        axios.get("http://localhost:8080/product/list", {
            params: pageRequestDTO
        })
            .then(res => {
                setPageResponseDTO(res.data)
            }).catch(error => {
            console.log(error);
        })

    }, [pageRequestDTO]);

    const changePageRequest = (key, value) => {
        setPageRequestDTO((pageRequestDTO) => {
            let pageRequest = {...pageRequestDTO};
            pageRequest[key] = value;
            return pageRequest;
        });
    };

    if (newCate !== cate
        && newCate !== null) {
        console.log(newCate)
        setCate(newCate);
        resetPageRequest()
        changePageRequest('cate', newCate)
        console.log('cate')
    }
    if (newSearch !== search
        && newSearch !== null
    ) {
        setSearch(newSearch);
        resetPageRequest()
        changePageRequest('search', newSearch);
        console.log('search')
    }
    if (newType !== type) {
        setType(newType);
        resetPageRequest()
        changePageRequest('type', newType);
        console.log('type')
    }

    function resetPageRequest() {
        changePageRequest('pg', 1)
        changePageRequest('type', 'sold')
    }

    return (<section className="list">

        <Routes>
            <CateRoot thisCate={cate}></CateRoot>

            <Route path="/view" element={<>
                <ListSort changePageRequest={changePageRequest}
                          pageRequestDTO={pageRequestDTO}
                ></ListSort>
                <ProductItem pageResponseDTO={pageResponseDTO}></ProductItem>
                <PageNavigation pageResponseDTO={pageResponseDTO}
                                changePageRequest={changePageRequest}></PageNavigation>
            </>
            }>
            </Route>


        </Routes>
    </section>)
}

function ListSort({changePageRequest, pageRequestDTO}) {


    return <>
        <ul className="sort">
            <li>
                <a onClick={() => changePageRequest('type', 'sold')}
                   style={{cursor: 'pointer', userSelect: 'none'}}
                   className={pageRequestDTO.type === 'sold' ? 'on' : ''}>판매많은순</a></li>
            <li>
                <a onClick={() => changePageRequest('type', 'price')}
                   style={{cursor: 'pointer', userSelect: 'none'}}
                   className={pageRequestDTO.type === 'price' ? 'on' : ''}>낮은가격순</a></li>
            <li>
                <a onClick={() => changePageRequest('type', 'priceAsc')}
                   style={{cursor: 'pointer', userSelect: 'none'}}
                   className={pageRequestDTO.type === 'priceAsc' ? 'on' : ''}>높은가격순</a></li>
            <li>
                <a onClick={() => changePageRequest('type', 'score')}
                   style={{cursor: 'pointer', userSelect: 'none'}}
                   className={pageRequestDTO.type === 'score' ? 'on' : ''}>평점높은순</a></li>
            <li>
                <a onClick={() => changePageRequest('type', 'review')}
                   style={{cursor: 'pointer', userSelect: 'none'}}
                   className={pageRequestDTO.type === 'review' ? 'on' : ''}>후기많은순</a></li>
            <li>
                <a onClick={() => changePageRequest('type', 'rdate')}
                   style={{cursor: 'pointer', userSelect: 'none'}}
                   className={pageRequestDTO.type === 'rdate' ? 'on' : ''}>최근등록순</a></li>
        </ul>
    </>
}


export default List;