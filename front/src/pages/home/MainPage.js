import {useEffect, useState} from "react";
import axios from "axios";
import {API_BASE_URL, HOME_URL} from "../../App";
import {changeDTO} from "../../store/changeDTO";
import {Link} from "react-router-dom";

function MainPage() {

    let [list, setList] = useState({
        hit: [],
        recomment: [],
        new: [],
        discount: [],
    });

    const images = ([
        process.env.REACT_APP_HOME_URL + '/images/banner/5908972.jpg'
        , process.env.REACT_APP_HOME_URL + '/images/banner/5908972.jpg'
        , process.env.REACT_APP_HOME_URL + '/images/banner/5908972.jpg'
    ])

    useEffect(() => {
        axios.get(`${API_BASE_URL}/product/indexList?type=hit`).then((res) => {
            changeDTO(setList, 'hit', res.data);
        }).catch((err) => {
            console.log(err);
        })
        axios.get(`${API_BASE_URL}/product/indexList?type=recomment`).then((res) => {
            changeDTO(setList, 'recomment', res.data);
        }).catch((err) => {
            console.log(err);
        })
        axios.get(`${API_BASE_URL}/product/indexList?type=new`).then((res) => {
            changeDTO(setList, 'new', res.data);
        }).catch((err) => {
            console.log(err);
        })
        axios.get(`${API_BASE_URL}/product/indexList?type=discount`).then((res) => {
            changeDTO(setList, 'discount', res.data);
        }).catch((err) => {
            console.log(err);
        })

    }, []);

    return (
        <section>
            <section className="slider">
                <ul>
                    <SliderItem images={images}></SliderItem>
                </ul>
            </section>

            <ProductList type="hit" name="히트" list={list.hit} type="hit"></ProductList>
            <ProductList type="recomment" name="추천" list={list.recomment} type="recomment"></ProductList>
            <ProductList type="new" name="최신" list={list.new} type="new"></ProductList>
            <ProductList type="discount" name="할인" list={list.discount} type="discount"></ProductList>
        </section>
    )
}

function ProductList({list, type}) {
    let [typeName, setTypeName] = useState("");


    useEffect(() => {
        if (type === 'hit') {
            setTypeName('히트');
        } else if (type === 'recomment') {
            setTypeName('추천')
        } else if (type === 'new') {
            setTypeName('최신')
        } else if (type === 'discount') {
            setTypeName('할인')
        }
    }, []);
    return (
        <section className="hit">
            <h3><span>{typeName}상품</span></h3>
            {Array.isArray(list) && list.map((item, index) => {
                return (
                    <ProductItem item={item} key={index}></ProductItem>
                )
            })}

        </section>

    )
}

function ProductItem({item}) {
    function discountCheck(item) {
        if (item.discount > 0) {
            return <>
                <div className="org_price">
                    <del>{item.price.toLocaleString()}</del>
                    <span>{item.discount}%</span>
                </div>
                <div className="dis_price">
                    <ins>{(item.price - (item.discount * item.price / 100)).toLocaleString()}</ins>
                    {item.delivery === 0 && <span style={{marginLeft: '5px'}} className="free">무료배송</span>}
                </div>
            </>
        } else
            return <>
                <div className="dis_price">
                    <ins>{(item.price.toLocaleString())}</ins>
                    {item.delivery === 0 && <span style={{marginLeft: '5px'}} className="free">무료배송</span>}
                </div>
            </>
    }

    if (item !== undefined)
        return (
            <article>
                <Link style={{cursor: "pointer"}} to={`${HOME_URL}/product/view?prodNo=${item.prodNo}`}>
                    <div className="thumb">
                        <img src={`${process.env.REACT_APP_HOME_URL}/images/thumbs/${item.thumb1}`}
                             style={{width: "230px", height: '230px'}} alt="item1"/>
                    </div>
                    <h2>{item.prodName}</h2>
                    <p>{item.descript}</p>

                    {discountCheck(item)}
                </Link>
            </article>
        )
}


function SliderItem({images}) {
    return (

        images.map((image, index) => {
            return (
                <li key={image+index}>
                    <a href="#"
                    ><img src={image} alt="item1" style={{width: '985px', height: '447px'}}
                    /></a>
                </li>
            )
        })

    )
}

export default MainPage;