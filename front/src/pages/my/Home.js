import MyNav from "./myNav";
import React, {useEffect, useState} from "react";
import axios from "axios";
import {API_BASE_URL} from "../../App";
import Menu from "./Menu";
import Latest from "./home/Latest";
import Point from "./home/Point";
import Review from "./home/Review";
import Qna from "./home/Qna";
import MyInfo from "./home/MyInfo";
import {createTokenHeader, retrieveStoredToken} from "../../slice/tokenSlice";
import {changeDTO} from "../../store/changeDTO";
import MyReview from "./review/MyReview";
import MyCoupon from "./coupon/MyCoupon";
import MyQna from "./qna/MyQna";
import MyPoint from "./point/MyPoint";
import MyOrder from "./order/MyOrder";

function Home() {
    let [userData, setUserData] = useState({});
    let [userOrder, setUserOrderItems] = useState([])
    let [userPoint, setUserPoint] = useState([])
    let [userReview, setUserReview] = useState([])
    let [member, setMember] = useState({})
    let [userQna, setUserQnA] = useState([])
    let memberUid = localStorage.getItem('memberUid');
    let [pageRequestDTO, setPageRequestDTO] = useState({
        pg: 1, size: 10, type: '', memberUid: memberUid
    })
    let [pageResponseDTO, setPageResponseDTO] = useState({
        dtoList: [], end: 10, start: 1, next: true, prev: true, total: 10, size: 10
    });
    let [divName, setDivName] = useState('home');
    useEffect(() => {
        if (memberUid !== null && retrieveStoredToken().token != null) {
            axios.get(`${API_BASE_URL}/member/me`, createTokenHeader(retrieveStoredToken().token))
                .then(response => {
                    setMember(response.data)
                }).catch(error => console.log('유저 정보가 없습니다.'))
        }
        //유저 포인트 들고오기
        axios.get(`${API_BASE_URL}/my/list`, {params: pageRequestDTO})
            .then(res => {
                setPageResponseDTO(res.data)
            }).catch(error => {
            console.log(error);
        })
    }, [pageRequestDTO]);
    useEffect(() => {
        changeDTO(setPageRequestDTO, 'type', divName)
        changeDTO(setPageRequestDTO, 'pg', 1)
    }, [divName]);
    useEffect(() => {
        if (memberUid !== null) {
            if (memberUid !== null && retrieveStoredToken().token != null) {

                axios.get(`${API_BASE_URL}/my/memberCount`, {
                    headers: {
                        'Authorization': 'Bearer ' + localStorage.getItem('token')
                    }, params: {
                        memberUid: memberUid
                    }
                }).then((response) => {
                    setUserData(response.data)
                }).catch(error => {
                    console.log(error);
                })
            }

            //유저 포인트 들고오기
            axios.get(`${API_BASE_URL}/my/list`, {
                params: {pg: 1, size: 3, type: 'point', memberUid: memberUid}
            })
                .then(res => {
                    setUserPoint(res.data.pointDTOS)
                }).catch(error => {
                console.log(error);
            })
            //유저 오더 들고오기
            axios.get(`${API_BASE_URL}/my/list`, {
                params: {pg: 1, size: 3, type: 'order', memberUid: memberUid}
            })
                .then(res => {
                    setUserOrderItems(res.data.orderItemDTOS)
                }).catch(error => {
                console.log(error);
            })
            //유저 리뷰 들고오기
            axios.get(`${API_BASE_URL}/my/list`, {
                params: {pg: 1, size: 5, type: 'review', memberUid: memberUid}
            })
                .then(res => {
                    setUserReview(res.data.reviewDtoList)
                }).catch(error => {
                console.log(error);
            })
            //유저 QnA 들고오기
            axios.get(`${API_BASE_URL}/my/list`, {
                params: {
                    pg: 1, size: 5, type: 'qna', memberUid: memberUid
                }
            })
                .then(res => {
                    setUserQnA(res.data.qnaDTOS)
                }).catch(error => {
                console.log(error);
            })
        }
    }, []);


    console.log(pageResponseDTO)

    function maskingName(name) {
        if (name.length <= 2) {
            return name.replace(name.substring(0, 1), "*");
        }

        return (
            name[0] +
            "*".repeat(name.substring(1, name.length - 1).length) +
            name[name.length - 1]
        );
    }


    const handleMaskText = (text) => {
        // Assuming you want to mask from the 4th character onward with asterisks
        const maskedText = text.substring(0, 3) + '*'.repeat(text.length - 3);
        return (maskedText);
    }

    let [emailFirst, setEmailFirst] = useState()
    let [emailEnd, setEmailEnd] = useState()
    let [email, setEmail] = useState('')
    useEffect(() => {
        if (member.email !== undefined) {
            setEmailFirst(member.email.split("@", 1)[0])
            setEmailEnd(member.email.split("@", 2)[1])
        }
    }, [member]);
    useEffect(() => {
        setEmail(emailFirst + '@' + emailEnd)
    }, [emailFirst, emailEnd]);

    console.log(email)
    let [emailOption, setEmailOption] = useState('')

    return <>

        <div id="my">

            <MyNav setDivName={setDivName} divName={divName} userData={userData}></MyNav>
            <div className={divName}>
                <Menu divName={divName} setDivName={setDivName}></Menu>
                {memberUid !== null ? <section>
                    <a href="#"><img src={`${process.env.REACT_APP_HOME_URL}/images/my/my_banner2.png`}
                                     alt="패션, 타운 하나로 끝" className="banner"/></a>
                    {divName === 'info' && <>
                        <article>
                            <h3>회원정보 설정</h3>

                            <table border="0">
                                <tr>
                                    <td>사용자 ID</td>
                                    <td>{handleMaskText(member.uid)}</td>
                                </tr>
                                <tr>
                                    <td>비밀번호</td>
                                    <td>
                                        <button id="btnChangePass">비밀번호 수정</button>
                                    </td>
                                </tr>
                                <tr>
                                    <td>이름</td>
                                    <td>{maskingName(member.name)}</td>
                                </tr>
                                <tr>
                                    <td>생년월일</td>
                                    <td>1983년 05월 03일</td>
                                </tr>
                                <tr>
                                    <td>E-mail</td>
                                    <td>
                                        <input type="text" name="email1" value={email.split("@", 1)}
                                               onChange={(e)=>{
                                                   setEmailFirst(e.target.value)
                                               }}
                                        />@
                                            <input type="text" name="email2" value={(email.split("@", 2)[1])}
                                                   onChange={(e) => {
                                                       if (emailOption === '직접입력')
                                                           setEmailEnd(e.target.value)
                                                   }}
                                            />
                                            <select onChange={(e) => {
                                                setEmailOption(e.target.value)
                                                if (e.target.value !== '직접입력')
                                                    setEmailEnd(e.target.value)
                                                else
                                                    setEmailEnd('')
                                            }}>
                                                <option>직접입력</option>
                                                <option selected={emailEnd === 'naver.com'}>naver.com</option>
                                                <option selected={emailEnd === 'daum.net'}>daum.net</option>
                                                <option selected={emailEnd === 'gmail.com'}>gmail.com</option>
                                                <option selected={emailEnd === 'nate.com'}>nate.com</option>
                                                <option selected={emailEnd === 'outlook.com'}>outlook.com</option>
                                            </select>
                                            <button id="btnChangeEmail">수정하기</button>
                                    </td>
                                </tr>
                                <tr>
                                    <td>휴대폰</td>
                                    <td>
                                        <p className="hp">
                                            <input type="text" name="hp1" value="010"/>-
                                            <input type="text" name="hp2" value="1234"/>-
                                            <input type="text" name="hp3" value="1001"/>
                                            <button id="btnChangeHp">수정하기</button>
                                        </p>
                                    </td>
                                </tr>
                                <tr>
                                    <td>주소</td>
                                    <td>
                                        <input type="text" name="zip" value={member.zip}/>
                                        <button id="btnFindZip">주소검색</button>
                                        <p className="address">
                                            <input type="text" name="addr1" value={member.addr1}/>
                                            <input type="text" name="addr2" value={member.addr2}/>
                                        </p>
                                    </td>
                                </tr>
                                <tr>
                                    <td>회원탈퇴</td>
                                    <td>
                                        <button id="btnWithdraw">탈퇴하기</button>
                                    </td>
                                </tr>
                            </table>
                            <button id="btnInfoChange">수정하기</button>
                        </article>
                    </>}
                    {divName === 'order' && <>
                        <MyOrder setPageRequestDTO={setPageRequestDTO} pageResponseDTO={pageResponseDTO}></MyOrder>
                    </>}
                    {divName === 'point' && <>
                        <MyPoint setPageRequestDTO={setPageRequestDTO} pageResponseDTO={pageResponseDTO}></MyPoint>
                    </>}
                    {divName === 'coupon' && <>
                        <MyCoupon pageResponseDTO={pageResponseDTO} setPageRequestDTO={setPageResponseDTO}
                                  userData={userData}></MyCoupon>
                    </>}
                    {divName === 'qna' && <>
                        <MyQna pageResponseDTO={pageResponseDTO} setPageRequestDTO={setPageRequestDTO}></MyQna>
                    </>}
                    {divName === 'home' && <>
                        <Latest userOrder={userOrder} setDivName={setDivName}></Latest>
                        <Point userPoint={userPoint} setDivName={setDivName}></Point>
                        <Review userReview={userReview} setDivName={setDivName}></Review>
                        <Qna userQna={userQna} setDivName={setDivName}></Qna>
                        <MyInfo setDivName={setDivName} member={member}></MyInfo>
                    </>
                    }
                    {divName === 'review' && <>
                        <MyReview pageResponseDTO={pageResponseDTO}
                                  setPageRequestDTO={setPageRequestDTO}></MyReview>
                    </>}
                </section> : <section className="error" style={{
                    padding: '50px 0 !important', textAlign: 'center', fontSize: '15px',
                }}>데이터를 받아오는데 오류가 발생했습니다. 로그인 후 다시 시도해주세요.
                </section>
                }


            </div>
        </div>


    </>


}


export default Home;