import {useEffect, useState} from "react";
import axios from "axios";
import {useLocation} from "react-router-dom";
import ProductItem from "./ProductItem"
import PageNavigation from "./PageNavigation";
import CateRoot from "../CateRoot";
import ListSort from "./ListSort";
import {API_BASE_URL} from "../../../App";
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

    if (newCate !== cate
        && newCate !== null) {
        setCate(newCate);
        resetPageRequest()
    }
    if (newSearch !== search
        && newSearch !== null
    ) {
        setSearch(newSearch);
        resetPageRequest()
    }
    if (newType !== type) {
        setType(newType);
        resetPageRequest()
    }

    function resetPageRequest() {
        setPageRequestDTO({
            pg: 1, size: 10, cate: newCate, search: newSearch, type: newType
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
            <div className="group">
                <h3><strong>{pageRequestDTO.search}</strong>검색결과 <em>(총&nbsp;:&nbsp;<span>{pageResponseDTO.total}</span>&nbsp;건)</em></h3>
                <div>
                    <input type="text" name="search"/>
                    <input type="submit" value="검색"/>
                    <span>
                  <label><input type="checkbox" name="chk" value="상품명"/>상품명</label>
                  <label><input type="checkbox" name="chk" value="상품설명"/>상품설명</label>
                  <label><input type="checkbox" name="chk" value="상품가격"/>상품가격</label>
                  <input type="text" name="min"/>원&nbsp;~&nbsp;<input type="text" name="max"/>원
              </span>
                </div>
                <p className="info">
                    상세검색을 선택하지 않거나, 상품가격을 입력하지 않으면 현재 결과내에서 검색합니다.<br/>
                    검색어는 최대 10글자까지, 여러개의 검색어를 공백으로 구분하여 입력 할수 있습니다.
                </p>
            </div>

            <ProductItem pageResponseDTO={pageResponseDTO}></ProductItem>

            <PageNavigation pageResponseDTO={pageResponseDTO} changePageRequest={changePageRequest}>

            </PageNavigation>
        </>
    )
}


export default List;