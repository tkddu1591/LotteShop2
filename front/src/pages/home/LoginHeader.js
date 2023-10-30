import {Link, useNavigate} from "react-router-dom";
import {HOME_URL} from "../../App";
import {logoutActionHandler} from "../../slice/tokenSlice";
import {useState} from "react";

function LoginHeader() {
    let [member] = useState(localStorage.getItem('memberUid'));
    let navigate = useNavigate();


    return <>
        <div className="top">
            <div>

                {member === null ?
                    <>
                        <Link to={HOME_URL + "/member/login"}>로그인</Link>
                        <Link to={HOME_URL + "/member/join"}>회원가입</Link>
                    </>
                    :
                    <>
                        <a style={{color:'#E60012'}}>{member}</a>
                        <a style={{cursor: 'pointer', userSelect: 'none'}}
                           onClick={() => {
                               logoutActionHandler()
                               navigate(0)
                           }}>로그아웃</a>
                        <Link to={`${process.env.REACT_APP_HOME_URL}/my/home`}>마이페이지</Link>
                        {localStorage.getItem('authority')==='ROLE_ADMIN'&&<Link to={`${process.env.REACT_APP_API_ROOT}/admin/index`}>관리자 페이지</Link>}
                        <a onClick={() => {
                            navigate(process.env.PUBLIC_URL + "/product/cart")
                        }}
                           style={{cursor: 'pointer', userSelect: 'none'}}
                        ><i className="fa fa-shopping-cart" aria-hidden="true"

                        ></i
                        >&nbsp;장바구니</a
                        >
                    </>}


                <Link to={HOME_URL + "/"}>홈</Link>
            </div>
        </div>
    </>
}

export default LoginHeader