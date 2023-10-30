import {useEffect, useState} from "react";
import axios from "axios";
import {useLocation} from "react-router-dom";
import ProductItem from "./ProductItem"
import PageNavigation from "./PageNavigation";
import CateRoot from "../CateRoot";
import ListSort from "./ListSort";
import {API_BASE_URL} from "../../../App";
import {changeDTO} from "../../../store/changeDTO";

function List() {
    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);

    const newSearch = searchParams.get('search');
    const [search, setSearch] = useState(newSearch);
    const newType = searchParams.get('type');
    const [type, setType] = useState(newType);
    const [num1, setNum1] = useState(0);
    const [num2, setNum2] = useState(0);
    const [detailSearch, setDetailSearch] = useState(newSearch);
    const newCate = searchParams.get('cate');
    const [cate, setCate] = useState(newCate);
    const [check, setCheck] = useState({
        numCheck: false,
        prodName: true,
        descript: false,
    });

    let [pageRequestDTO, setPageRequestDTO] = useState({
        pg: 1, size: 10, cate: newCate, search: search, type: type
    })
    let [pageResponseDTO, setPageResponseDTO] = useState({
        cate: parseInt(cate), dtoList: [], end: 10, start: 1, next: true, prev: true, total: 10, size: 10
    });
    console.log(cate);
    console.log(newCate);
    useEffect(() => {

        console.log(pageRequestDTO);
        axios.get(`${API_BASE_URL}/product/list`, {
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

    // 카테 및 헤더 변경시
    if (newCate !== cate
        && newCate !== null) {
        setCate(newCate);
    }
    if (newSearch !== search
    ) {
        setPageRequestDTO({
            pg: 1,
            size: 10,
            search: newSearch,
        })
        setSearch(newSearch);
    }
    if (newType !== type
        && newType !== null) {
        setType(newType);
    }
    useEffect(() => {
    }, [search]);
    useEffect(() => {
        setPageRequestDTO({
            pg: 1,
            size: 10,
            type: newType,
        })
    }, [type]);
    useEffect(() => {
        setPageRequestDTO({
            pg: 1,
            size: 10,
            cate: newCate,
        })
    }, [cate]);

    function resetPageRequest() {
        let min, max
        if (num1=='') {
            min = 0
        } else{
            min=num1
        }


        if (num2==''){
            max=10000000
        }else{
            max=num2
        }
        setPageRequestDTO({
            pg: 1,
            size: 10,
            cate: newCate,
            search: detailSearch,
            type: newType,
            min: min,
            max: max,
            isNum: check.numCheck,
            isProdName: check.prodName,
            isDescript: check.descript
        })
    }

    return (
        <>
            <CateRoot thisCate={cate}></CateRoot>

            <ListSort changePageRequest={changePageRequest}
                      pageRequestDTO={pageRequestDTO}
                      cate={newCate}
                      search={newSearch}
            ></ListSort>

            <Group pageRequestDTO={pageRequestDTO} resetPageRequest={resetPageRequest} setDetailSearch={setDetailSearch}
                   pageResponseDTO={pageResponseDTO} check={check} setCheck={setCheck} setNum1={setNum1}
                   setNum2={setNum2} num1={num1} num2={num2}></Group>

            <ProductItem pageResponseDTO={pageResponseDTO}></ProductItem>

            <PageNavigation pageResponseDTO={pageResponseDTO} changePageRequest={changePageRequest}>

            </PageNavigation>
        </>
    )
}

function Group({
                   pageRequestDTO,
                   pageResponseDTO,
                   check,
                   setDetailSearch,
                   resetPageRequest,
                   setCheck,
                   setNum1,
                   setNum2,
                   num1,
                   num2
               }) {


    const handleKeyDown = (e) => {
        if (e.key === 'Enter') {
            resetPageRequest() // 작성한 댓글 post 요청하는 함수
        }
    };
    return <>
        <div className="group">
            <h3><strong>{pageRequestDTO.search}</strong>검색결과 <em>(총&nbsp;:&nbsp;
                <span>{pageResponseDTO.total.toLocaleString()}</span>&nbsp;건)</em>
                {pageRequestDTO.isNum &&
                    <em style={{marginLeft: '10px'}}>{pageRequestDTO.min !== 0 && pageRequestDTO.min!==undefined && parseInt(pageRequestDTO.min).toLocaleString() + '원'}
                        ~ {pageRequestDTO.max !== undefined && pageRequestDTO.max !== 10000000 ? parseInt(pageRequestDTO.max).toLocaleString() + '원' : ''} </em>}
            </h3>
            <div>
                <input type="text" name="search" onKeyUp={handleKeyDown} onChange={(e) => {
                    setDetailSearch(e.target.value)
                }}/>
                <input type="submit" value="검색" onClick={() => {
                    resetPageRequest()
                }}/>
                <span>
                  <label><input type="checkbox" name="chk" checked={check.prodName} readOnly onClick={() => {
                      changeDTO(setCheck, 'prodName', !check.prodName)
                      if (check.descript) {
                          changeDTO(setCheck, 'descript', false)
                      }
                  }}/>상품명</label>
                  <label><input type="checkbox" name="chk" checked={check.descript} readOnly onClick={() => {
                      changeDTO(setCheck, 'descript', !check.descript)
                      if (check.prodName) {
                          changeDTO(setCheck, 'prodName', false)
                      }
                  }}/>상품설명</label>
                  <label><input type="checkbox" name="chk" checked={check.numCheck} readOnly onClick={() => {
                      changeDTO(setCheck, 'numCheck', !check.numCheck)
                  }}/>상품가격</label>
                  <input type="text" value={num1} onKeyUp={handleKeyDown} onChange={(e) => {
                      setNum1(e.target.value)
                  }}/>원&nbsp;~&nbsp;
                    <input type="text" value={num2} onKeyUp={handleKeyDown} onChange={(e) => {
                        setNum2(e.target.value)
                    }}/>원
              </span>
            </div>
            <p className="info">
                상세검색을 선택하지 않거나, 상품가격을 입력하지 않으면 현재 결과내에서 검색합니다.<br/>
                검색어는 최대 10글자까지, 여러개의 검색어를 공백으로 구분하여 입력 할수 있습니다.
            </p>
        </div>
    </>

}

export default List;