import './App.css';
import {lazy, memo, Suspense, useEffect,} from "react";
import {Outlet, Route, Routes} from "react-router-dom";
import axios from "axios";
import {changeCate1, changeCate2} from "./slice/cateSilce";
import {useDispatch, useSelector} from "react-redux";
import './pages/home/slider.css';

const Aside = lazy(() => import('./pages/home/Aside.js'))
const Footer = lazy(() => import('./pages/home/Footer.js'))
const Header = lazy(() => import('./pages/home/Header.js'))
const MainPage = lazy(() => import('./pages/home/MainPage.js'))
const List = lazy(() => import('./pages/product/list/List.js'))

function App() {

    let cate1 = useSelector((state) => state.cate1);
    let cate2 = useSelector((state) => state.cate2);
    let dispatch = useDispatch();

    function fallbackData() {
        return <div>로딩중</div>
    }

    useEffect(() => {
        if (cate1 == null) {
            axios.get('/product/cate1').then(res => {
                dispatch(changeCate1(res.data))
            })
        }
        if (cate2 == null) {
            axios.get('/product/cate2').then(res => {
                dispatch(changeCate2(res.data))
            })
        }
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
                        <Route path="list" element={<List></List>}/>
                    </Route>

                    <Route path="" element={<MainPage></MainPage>}/>

                </Route>
            </Routes>
        </>
    )
}

function BannerTop() {
    return (
        <div id="bannerTop" className="on" style={{background: '#e4dfdf'}}>
            <article>
                <a href="#"><img src={'/images/topBanner1.png'}/></a>
                <button className="btnClose">close</button>
            </article>
        </div>
    )
}

export default App;



