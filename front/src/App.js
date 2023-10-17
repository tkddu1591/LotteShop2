import './App.css';
import {lazy, memo, Suspense, useEffect, useState,} from "react";
import {Outlet, Route, Routes} from "react-router-dom";
import axios from "axios";
import {changeCate1, changeCate2} from "./slice/cateSilce";
import {useDispatch, useSelector} from "react-redux";
import './pages/home/slider.css';
import CateRoot from "./pages/product/CateRoot";
import {deleteBanner} from "./slice/bannerSilce";
import Order from "./pages/product/order/Order";
import {insertMember} from "./slice/memberSlice";

export const API_BASE_URL = process.env.REACT_APP_API_ROOT;
export const HOME_URL = process.env.REACT_APP_HOME_URL;
const Aside = lazy(() => import('./pages/home/Aside.js'))
const Footer = lazy(() => import('./pages/home/Footer.js'))
const Header = lazy(() => import('./pages/home/Header.js'))
const MainPage = lazy(() => import('./pages/home/MainPage.js'))
const List = lazy(() => import('./pages/product/list/List.js'))
const View = lazy(() => import('./pages/product/view/View.js'))
const Cart = lazy(() => import('./pages/product/cart/Cart.js'))
const Complete = lazy(() => import('./pages/product/complete/Complete.js'))

function App() {

    let dispatch = useDispatch();

    function fallbackData() {
        return <div>로딩중</div>
    }

    let member ={
        uid:'user',
        pass:'user',
    }
    useEffect(() => {
        axios.get('http://localhost:8080/product/cate1').then(res => {
            dispatch(changeCate1(res.data))
            console.log(res.data);
        }).catch(error => {
            console.log(error);
        })
        axios.get('/product/cate2').then(res => {
            dispatch(changeCate2(res.data))
            console.log(res.data);
        }).catch(error => {
            console.log(error);
        })
        //user 데이터 받아오기 나중에는 로그인 페이지로 처리
        axios.post('/member/login',member, {
            headers: {
                'Content-Type': 'application/json',
            }
        }).then(response => {
            dispatch(insertMember(response.data));
        }).catch(error => {
            console.log(error);
        })
    }, []);


    let BannerTopMemo = memo(function () {
        return <BannerTop></BannerTop>
    })
    let HeaderMemo = memo(function () {
        return <Header></Header>
    })
    let FooterMemo = memo(function () {
        return <Footer></Footer>
    })
    let AsideMemo = memo(function () {
        return <Aside></Aside>
    })

    return (
        <>
            <Routes>
                <Route path="/" element={
                    <Suspense fallback={fallbackData()}>
                        <BannerTopMemo/>
                        <HeaderMemo></HeaderMemo>
                        <main id="product">
                            <AsideMemo></AsideMemo>
                            <Outlet></Outlet>
                        </main>
                        <FooterMemo></FooterMemo>
                    </Suspense>
                }>
                    <Route path="product">
                        <Route path="list" element={<section className="list"><List></List></section>}/>
                        <Route path="view" element={<Suspense fallback={fallbackData()}>
                            <section className="view">
                                <CateRoot></CateRoot>
                                <View></View>
                            </section>
                        </Suspense>}/>
                        <Route path="cart" element={<Suspense fallback={fallbackData()}>
                            <section className="cart">
                                <CateRoot type={'cart'}></CateRoot>
                                <Cart></Cart>
                            </section>
                        </Suspense>}/>

                        <Route path="order" element={<Suspense fallback={fallbackData()}>
                            <section className="order">
                                <CateRoot type='order'></CateRoot>
                                <Order></Order>
                            </section>
                        </Suspense>}/>
                        <Route path="complete" element={<Suspense fallback={fallbackData()}>
                            <section className="complete">
                                <CateRoot type='complete'></CateRoot>
                                <Complete></Complete>
                            </section>
                        </Suspense>}/>
                    </Route>

                    <Route path="" element={<MainPage></MainPage>}/>

                </Route>
            </Routes>
        </>
    )
}

function BannerTop() {

    let dispatch = useDispatch()
    let banner = useSelector((state) => state.banner);
    if (banner) {
        return (
            <div id="bannerTop" className="on" style={{background: '#e4dfdf'}}>
                <article>
                    <a href="#"><img src={'/images/topBanner1.png'}/></a>
                    <button className="btnClose" onClick={() => {
                        dispatch(deleteBanner())
                    }}>close
                    </button>
                </article>
            </div>
        )
    } else return null;
}

export default App;



