import {useSelector, useDispatch} from "react-redux";
import {changeCateNames} from "../../slice/cateSilce";
import {useLocation} from "react-router-dom";

function CateRoot({thisCate, type}) {

    let cate1DTO = useSelector((state) => state.cate1);
    let cate2DTO = useSelector((state) => state.cate2);
    let dispatch = useDispatch()
    let newCategory = {}


    const cateNames = useSelector((state) => state.cateNames);
    const categoryNo = useSelector((state) => state.categoryNo);
    if (thisCate === undefined) {
        thisCate = categoryNo
    }
    else if(thisCate >= 1000) {
        Array.isArray(cate2DTO) && cate2DTO.forEach(function (item, index) {
                if (item.cate2 === parseInt(thisCate)) {
                    newCategory.c2Name = item.c2Name;
                    Array.isArray(cate1DTO) && cate1DTO.forEach(function (item2, index) {
                            if (item2.cate1 === parseInt(item.cate1)) {
                                newCategory.c1Name = item2.c1Name;
                                if (newCategory.c2Name !== cateNames.c2Name) {
                                    dispatch(changeCateNames(newCategory))
                                }

                                return false;
                            }
                        }
                    )
                    return false;
                }
            }
        )
    } else {

        Array.isArray(cate1DTO) && cate1DTO.forEach(function (item, index) {
            if (item.cate1 === parseInt(thisCate)) {
                newCategory.c1Name = item.c1Name;

                if (cateNames.c2Name != null || newCategory.c1Name !== cateNames.c1Name) {
                    dispatch(changeCateNames(newCategory))
                }
                return false;
            }
        })

    }


    function getCateName() {
        if (cateNames.c2Name != null) {
            return <>
                > <span>{cateNames.c1Name}</span> > <strong>{cateNames.c2Name}</strong>
            </>
        }
        if (cateNames.c1Name != null) {
            return <>
                > <span>{cateNames.c1Name}</span>
            </>
        }
        return null;
    }

    if (type === "cart")
        return <>
            <nav>
                <h1>장바구니</h1>
                <p>HOME > 장바구니</p>
            </nav>
        </>
    else {
        return <>
            <nav>
                <h1>상품목록</h1>
                <p>HOME {getCateName()}</p>
            </nav>
        </>
    }
}


export default CateRoot;