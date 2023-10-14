import {Link, useNavigate} from "react-router-dom";
import {useState} from "react";

function Header() {
    let navigator = useNavigate();
    let [search, setSearch] = useState('');
    return (
        <header>
            <div className="top">
                <div>
                    <a href="/member/login.html">로그인</a>
                    <a href="#">회원가입</a>
                    <a href="#">마이페이지</a>
                    <a href="#"
                    ><i className="fa fa-shopping-cart" aria-hidden="true"></i
                    >&nbsp;장바구니</a
                    >
                </div>
            </div>
            <div className="logo">
                <div>
                    <Link to={process.env.PUBLIC_URL + "/"}><img src="/images/header_logo.png" alt="로고"/></Link>
                    <div>
                        <input
                            onChange={(e) => {
                                setSearch(e.target.value)
                                console.log(e.target.value);
                            }}
                            onKeyUp={(e)=>{
                                if(e.keyCode === 13){
                                    navigator(process.env.PUBLIC_URL+"/product/list?search="+search)
                                }
                            }}


                            />
                        <button><i className="fa fa-search"
                                   onClick={(e) => {
                                       navigator(process.env.PUBLIC_URL+"/product/list?search="+search)
                                   }}
                        ></i></button>
                    </div>
                </div>
            </div>
            <div className="menu">
                <div>
                    <ul>
                        <li><a href="#">히트상품</a></li>
                        <li><a href="#">추천상품</a></li>
                        <li><a href="#">최신상품</a></li>
                        <li><a href="#">인기상품</a></li>
                        <li><a href="#">할인상품</a></li>
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