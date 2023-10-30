import {useSelector} from "react-redux";
import {Link} from "react-router-dom";
import {API_BASE_URL, HOME_URL} from "../../App";
import {useEffect, useState} from "react";
import axios from "axios";

function Aside() {

    const cate1 = useSelector((state) => state.cate1);
    const cate2 = useSelector((state) => state.cate2);

    function cate2Cheak(cate1No) {
        if (cate2 != null) {
            let cate2Terms2 = [];
            for (let cate2Item of cate2) {
                if (cate2Item.cate1 === cate1No) {
                    cate2Terms2.push(cate2Item);
                }
            }
            return cate2Terms2
        }
    }

    function cate2Names(cate1No) {
        let cate2Terms = [];
        // eslint-disable-next-line array-callback-return
        (Array.isArray(cate2Cheak(cate1No)) && cate2Cheak(cate1No).map((item, index) => {
            cate2Terms.push(item.c2Name)
        }))
        return cate2Terms
    }

    function cate2Nos(cate1No) {
        let cate2Terms = [];
        // eslint-disable-next-line array-callback-return
        (Array.isArray(cate2Cheak(cate1No)) && cate2Cheak(cate1No).map((item, index) => {
            cate2Terms.push(item.cate2)
        }))
        return cate2Terms
    }

    let [bestList, setBestList] = useState()
    useEffect(() => {
        axios.get(`${API_BASE_URL}/product/indexList?type=best`).then((res) => {
            setBestList(res.data);
        }).catch((err) => {
            console.log(err);
        })
    }, []);


    return (
        <aside>
            <ul className="category">
                <li><i className="fa fa-bars" aria-hidden="true"></i>카테고리</li>
                {Array.isArray(cate1) && cate1.map((item) => {
                    return <Categories key={item.c1Name} type={item.icon} name={item.c1Name}
                                       c2Name={cate2Names(item.cate1)}
                                       cate2={cate2Nos(item.cate1)}
                                       cate1={item.cate1}
                    ></Categories>
                })}
            </ul>

            <article className="best">
                <h1><i className="fas fa-crown"></i>베스트상품</h1>
                <BestProduct bestList={bestList}></BestProduct>
            </article>
        </aside>
    )
}

function BestProduct({bestList}) {

    function discountCheck(item) {
        if (item.discount > 0) {
            return <>
                <div className="org_price">
                    <del>{item.price.toLocaleString()}</del>
                    <span>{item.discount}%</span>
                </div>
                <div className="dis_price">
                    <ins>{(item.price - (item.discount * item.price / 100)).toLocaleString()}</ins>
                </div>
            </>
        } else {
            return <>

                <div className="dis_price">
                    <ins>{(item.price.toLocaleString())}</ins>
                </div>
            </>
        }
    }

    if (Array.isArray(bestList)) {
        return <ol>
            {bestList.map((item, index) => {
                return <li key={item.prodNo}>
                    <Link style={{cursor: "pointer"}} to={`${HOME_URL}/product/view?prodNo=${item.prodNo}`}>
                        <div className="thumb">
                            <i>{index + 1}</i>
                            <img src={`${process.env.REACT_APP_HOME_URL}/images/thumbs/${item.thumb1}`} alt="item1"/>
                        </div>
                        <article>
                            <h2>{item.prodName}</h2>

                            {discountCheck(item)}
                        </article>
                    </Link>
                </li>
            })}
        </ol>
    }
}

function Categories({type, name, c2Name, cate2, cate1}) {
    const cate = []
    // eslint-disable-next-line array-callback-return
    Array.isArray(c2Name) && c2Name.map((item, index) => {
        cate.push({cate2: cate2[index], c2Name: item})
    })


    return (
        <li>
            <Link to={HOME_URL + "/product/list?cate=" + cate1}
                  style={{cursor: 'pointer', userSelect: 'none'}}
            ><i className={"fas fa-" + type}></i>{name}<i
                className="fas fa-angle-right"
            ></i
            ></Link>
            <ol>
                {Array.isArray(cate) && cate.map((item, index) => {
                    return (
                        <li key={index}>
                            <Link to={HOME_URL + "/product/list?cate=" + item.cate2}
                                  style={{cursor: 'pointer', userSelect: 'none'}}
                            >{item.c2Name}</Link>
                        </li>
                    )
                })}
            </ol>
        </li>
    )
}

export default Aside;