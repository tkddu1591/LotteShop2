import {Link, useNavigate} from "react-router-dom";
import {HOME_URL} from "../../App";

function LoginHeader() {
    let navigate = useNavigate();
    return <>
            <div className="top">
                <div>
                    <Link to={HOME_URL + "/"}>홈</Link>
                    <Link to={HOME_URL + "/member/login"}>로그인</Link>
                    <Link to={HOME_URL+"/member/join"}>회원가입</Link>
                    <a href="#">마이페이지</a>
                    <a onClick={(e) => {
                        navigate(process.env.PUBLIC_URL + "/product/cart")
                    }}
                       style={{cursor: 'pointer', userSelect: 'none'}}
                    ><i className="fa fa-shopping-cart" aria-hidden="true"

                    ></i
                    >&nbsp;장바구니</a
                    >
                </div>
            </div>
    </>
}

export default LoginHeader