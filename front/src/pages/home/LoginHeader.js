import {Link, useNavigate} from "react-router-dom";
import {HOME_URL} from "../../App";

function LoginHeader() {
    let navigate = useNavigate();
    return <>
        <header>
            <div className="top">
                <div>
                    <Link to={HOME_URL + "/member/login"}>로그인</Link>
                    <a href="#">회원가입</a>
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
        </header>
    </>
}

export default LoginHeader