import {useSelector} from "react-redux";
import {Link, useNavigate} from "react-router-dom";

function Aside() {
    const content1 = [
        '남성의류', '여성의류', '잡화', '뷰티'
    ]
    const content2 = [
        '노트북/PC', '가전', '휴대폰', '기타'
    ]
    const content3 = [
        '신선식품', '가공식품', '건강식품', '생필품'
    ]
    const content4 = [
        '가구/DIY', '침구·커튼', '생활용품', '사무용품'
    ]

    const cate1 = useSelector((state) => state.cate1);
    const cate2 = useSelector((state) => state.cate2);

    function cate2Cheak(cate1No) {
        if (cate2 != null) {
            let cate2Terms2 = [];
            for (let cate2Item of cate2) {
                if (cate2Item.cate1 == cate1No) {
                    cate2Terms2.push(cate2Item);
                }
            }
            return cate2Terms2
        }
    }
    function cate2Names(cate1No){
        let cate2Terms=[];
        (Array.isArray(cate2Cheak(cate1No))&&cate2Cheak(cate1No).map((item, index) => {
            cate2Terms.push(item.c2Name)
        }))
        return cate2Terms
    }
    function cate2Nos(cate1No){
        let cate2Terms=[];
        (Array.isArray(cate2Cheak(cate1No)) &&cate2Cheak(cate1No).map((item, index) => {
            cate2Terms.push(item.cate2)
        }))
        return cate2Terms
    }



    return (
        <aside>
            <ul className="category">
                <li><i className="fa fa-bars" aria-hidden="true"></i>카테고리</li>
                {Array.isArray(cate1) && cate1.map((item, index) => {
                    return <Categories key={item.c1Name} type={item.icon} name={item.c1Name}
                                       c2Name={cate2Names(item.cate1)}
                                       cate2={cate2Nos(item.cate1)}
                                       cate1={item.cate1}
                    ></Categories>
                })}
            </ul>

            <article className="best">
                <h1><i className="fas fa-crown"></i>베스트상품</h1>
                <ol>
                    <BestProduct></BestProduct>
                    <BestProduct></BestProduct>
                    <BestProduct></BestProduct>
                    <BestProduct></BestProduct>
                    <BestProduct></BestProduct>
                </ol>
            </article>
        </aside>
    )
}

function BestProduct() {
    return (
        <li>
            <a href="#">
                <div className="thumb">
                    <i>5</i>
                    <img src="https://via.placeholder.com/230" alt="item1"/>
                </div>
                <article>
                    <h2>상품명</h2>
                    <div className="org_price">
                        <del>30,000</del>
                        <span>10%</span>
                    </div>
                    <div className="dis_price">
                        <ins>27,000</ins>
                    </div>
                </article>
            </a>
        </li>
    )
}

function Categories({type, name, c2Name,cate2, cate1}) {
    const cate =[]
    Array.isArray(c2Name) &&c2Name.map((item, index) => {
        cate.push({cate2:cate2[index],c2Name:item})
    })


    return (
        <li>
            <Link to={process.env.PUBLIC_URL+"/product/list?cate="+cate1}
                  style={ {cursor: 'pointer', userSelect: 'none'}}
            ><i className={"fas fa-" + type}></i>{name}<i
                className="fas fa-angle-right"
            ></i
            ></Link>
            <ol>
                {Array.isArray(cate) &&cate.map((item, index) => {
                    return (
                        <li key={index}>
                            <Link to={process.env.PUBLIC_URL+"/product/list?cate="+item.cate2}
                                  style={ {cursor: 'pointer', userSelect: 'none'}}
                            >{item.c2Name}</Link>
                        </li>
                    )
                })}
            </ol>
        </li>
    )
}

export default Aside;