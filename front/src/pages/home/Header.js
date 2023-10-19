import {Link, useLocation, useNavigate} from "react-router-dom";
import {useState} from "react";
import {changeCategoryNo, changeCateNames} from "../../slice/cateSilce";
import {useDispatch} from "react-redux";
import {HOME_URL} from "../../App";

function Header() {
    let navigator = useNavigate();

    let dispatch = useDispatch();


    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);
    const newCate = searchParams.get('cate');
    const [cate, setCate] = useState(newCate);
    const newType = searchParams.get('type');
    const [type, setType] = useState(newType);
    const newSearch = searchParams.get('search');
    let [search, setSearch] = useState('');

    return (
        <header>
            <div className="top">
                <div>
                    <Link  to={HOME_URL+"/member/login"}>로그인</Link>
                    <a href="#">회원가입</a>
                    <a href="#">마이페이지</a>
                    <a onClick={(e) => {
                        navigator(process.env.PUBLIC_URL + "/product/cart")
                    }}
                       style={{cursor: 'pointer', userSelect: 'none'}}
                    ><i className="fa fa-shopping-cart" aria-hidden="true"

                    ></i
                    >&nbsp;장바구니</a
                    >
                </div>
            </div>
            <div className="logo">
                <div>
                    <Link to={process.env.PUBLIC_URL + "/"}><img src={`${process.env.REACT_APP_HOME_URL}/images/header_logo.png`} alt="로고"/></Link>
                    <div>
                        <input
                            onChange={(e) => {
                                setSearch(e.target.value)
                            }}
                            onKeyUp={(e) => {
                                if (e.keyCode === 13) {
                                    dispatch(changeCateNames(''))
                                    dispatch(changeCategoryNo(0))
                                    navigator(process.env.PUBLIC_URL + "/product/list?search=" + search)
                                }
                            }}


                        />
                        <button><i className="fa fa-search"
                                   onClick={(e) => {
                                       navigator(process.env.PUBLIC_URL + "/product/list?search=" + search)
                                   }}
                        ></i></button>
                    </div>
                </div>
            </div>
            <div className="menu">
                <div>
                    <ul>
                        <li><a style={{fontWeight: (newCate === null ? newType === 'hit' ? 'bold' : null : null), cursor:'pointer', userSelect:'none'}}
                               onClick={() => {
                                   (navigator(process.env.PUBLIC_URL + "/product/list?type=hit"))
                               }
                               }>히트상품</a></li>
                        <li><a style={{fontWeight: (newCate === null ? newType === 'score' ? 'bold' : null : null), cursor:'pointer', userSelect:'none'}}
                               onClick={() => {
                                   (navigator(process.env.PUBLIC_URL + "/product/list?type=score"))
                               }
                               }>추천상품</a></li>
                        <li><a style={{fontWeight: (newCate === null ? newType === 'rdate' ? 'bold' : null : null), cursor:'pointer', userSelect:'none'}}
                               onClick={() => {
                                   (navigator(process.env.PUBLIC_URL + "/product/list?type=rdate"))
                               }
                               }>최신상품</a></li>
                        <li><a style={{fontWeight: (newCate === null ? newType === 'sold' ? 'bold' : null : null), cursor:'pointer', userSelect:'none'}}
                               onClick={() => {
                                   (navigator(process.env.PUBLIC_URL + "/product/list?type=sold"))
                               }
                               }>인기상품</a></li>
                        <li><a style={{fontWeight: (newCate === null ? newType === 'discount' ? 'bold' : null : null), cursor:'pointer', userSelect:'none'}}
                               onClick={() => {
                                   (navigator(process.env.PUBLIC_URL + "/product/list?type=discount"))
                               }
                               }>할인상품</a></li>
                    </ul>
                    <ul>
                        <li><a href="#">공지사항</a></li>
                        <li><a href="#">자주묻는질문</a></li>
                        <li><a href="#">문의하기</a></li>
                        <li><a href="#">고객센터</a></li>
                    </ul>
                </div>
            </div>
        </header>
    )
}

export default Header;