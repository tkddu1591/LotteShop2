import {useEffect, useState} from "react";
import {API_BASE_URL} from "../../App";
import axios from "axios";
import {changeDTO} from "../store/ChangeDTO";

function Login() {
    let [memberDTO, setMemberDTO] = useState({uid: '', pass: ''})
    let [memberCheck, setMemberCheck] = useState(false)
    console.log(memberDTO)
    return <div className="login">
        <nav>
            <h1>로그인</h1>
        </nav>

        <div>

            <table border="0">
                <tbody>
                    <tr>
                        <td>아이디</td>
                        <td><input type="text" name="uid" placeholder="아이디 입력"
                                   onChange={event => changeDTO(setMemberDTO, 'uid', event.target.value)}/></td>
                    </tr>
                    <tr>
                        <td>비밀번호</td>
                        <td><input type="password" name="pass"
                                   onChange={event => changeDTO(setMemberDTO, 'pass', event.target.value)}
                                   placeholder="비밀번호 입력"/></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit"
                   onClick={async (e) => {
                       await axios.post(`${API_BASE_URL}/member/login`, memberDTO, {
                           headers: {
                               'Content-Type': 'application/json',
                           }
                       }).then(response => {
                           console.log(response.data)
                       }).catch(error => setMemberCheck(true))
                   }}
                   value="로그인"/>
            <span>
                <label><input type="checkbox" name="auto"/>자동 로그인</label>
                {memberCheck &&
                    <div style={{color: 'red', marginTop: '10px'}}> 아이디 또는 비밀번호를 잘못 입력했습니다.<br/>입력하신 내용을 다시 확인해주세요.
                    </div>}
            </span>
            <span style={{position: 'absolute', left: '10px', bottom: '10px'}}>
                <span href="#" style={{border: 'none'}}>아이디찾기</span>
                <span href="#">비밀번호찾기</span>
                <span href="#">회원가입</span>
            </span>
            <a href="#" className="banner"><img
                src={`${process.env.REACT_APP_HOME_URL}/images/member/member_login_banner.jpg`}
                alt="1만원 할인 쿠폰 받기"/></a>

        </div>
        <img src={`${process.env.REACT_APP_HOME_URL}/images/member/member_certifi_logo.gif`} alt="banner"/>
    </div>

}

export default Login