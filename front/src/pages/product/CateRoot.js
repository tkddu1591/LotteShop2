import {useSelector} from "react-redux";

function CateRoot({thisCate}) {
    let cate1DTO = useSelector((state) => state.cate1);
    let cate2DTO = useSelector((state) => state.cate2);
    let newCategory = {}
    if (thisCate >= 1000) {

        Array.isArray(cate2DTO) && cate2DTO.forEach(function (item, index) {
            if (item.cate2 === parseInt(thisCate)) {
                newCategory.c2Name = item.c2Name;
                Array.isArray(cate1DTO) && cate1DTO.forEach(function (item2, index) {
                    if (item2.cate1 === parseInt(item.cate1)) {
                        newCategory.c1Name = item2.c1Name;
                        return false;
                    }
                })
                return false;
            }
        })
    } else {

        Array.isArray(cate1DTO) && cate1DTO.forEach(function (item, index) {
            if (item.cate1 === parseInt(thisCate)) {
                newCategory.c1Name = item.c1Name;
                return false;
            }
        })

    }

    function getCateName() {
        if (thisCate >= 1000) {
            return <>
                > <span>{newCategory.c1Name}</span> > <strong>{newCategory.c2Name}</strong>
            </>
        }
        if (thisCate >= 10) {
            return <>
                > <span>{newCategory.c1Name}</span>
            </>
        }
        return null;
    }

    return <nav>
        <h1>상품목록</h1>
        <p>HOME {getCateName()}</p>
    </nav>
}


export default CateRoot;