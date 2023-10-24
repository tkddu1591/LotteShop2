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
import MyPageNavigation from "./MyPageNavigation";
import {Link} from "react-router-dom";

function Home() {
    let [userData, setUserData] = useState({});
    let [userOrder, setUserOrderItems] = useState([])
    let [userPoint, setUserPoint] = useState([])
    let [userReview, setUserReview] = useState([])
    let [userQna, setUserQnA] = useState([])
    let memberUid = localStorage.getItem('memberUid');
    let [pageRequestDTO, setPageRequestDTO] = useState({
        pg: 1, size: 10, type: '', memberUid: memberUid
    })
    let [pageResponseDTO, setPageResponseDTO] = useState({
        dtoList: [], end: 10, start: 1, next: true, prev: true, total: 10, size: 10
    });
    let [memberDTO, setMemberDTO] = useState({});
    let [divName, setDivName] = useState('home');
    useEffect(() => {
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
                axios.get(`${API_BASE_URL}/member/me`, createTokenHeader(retrieveStoredToken().token))
                    .then(response => {
                        setMemberDTO(response.data)
                    }).catch(error => console.log('유저 정보가 없습니다.'))

                axios.get(`${API_BASE_URL}/my/memberCount`, {
                    headers: {
                        'Authorization': 'Bearer ' + localStorage.getItem('token')
                    }, params: {
                        memberUid: memberUid
                    }
                }).then((response) => {
                    console.log(response.data);
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
            console.log(pageRequestDTO);
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
    console.log(pageResponseDTO);

    function answer(value) {
        if (value === 0) {
            return <td className="status"><span style={{color: 'grey'}}>미확인</span></td>
        }
        if (value === 1) {
            return <td className="status"><span style={{color: '#8972EE'}}>검토중</span></td>
        }
        if (value === 2) {
            return <td className="status"><span className="answered">답변완료</span></td>
        }
    }

    function content(value, setAnswerCheck, index) {
        if (value.cate === 'cancel' || value.cate === 'delivery' || value.cate === 'order' || value.cate === 'safe') {
            return <td className="tit">
                <ul>
                    <li className="prodName"><Link
                        to={`${process.env.REACT_APP_HOME_URL}/product/view?prodNo=` + value.prodNo}>{value.prodName}</Link>
                    </li>
                    {value.answerComplete === 2 ? <li className="question"><span style={{cursor: 'pointer'}}
                                                                                 onClick={() => changeDTO(setAnswerCheck, index, !answerCheck[index])}
                    >{value.title}</span></li> : <li className="question">{value.title}</li>}
                </ul>
            </td>
        } else {
            return <>
                {value.answerComplete === 2 ? <td className="tit"><span style={{cursor: 'pointer'}}
                                                                        onClick={() => changeDTO(setAnswerCheck, index, !answerCheck[index])}>{value.title}</span>
                </td> : <td className="tit">{value.title}</td>}</>
        }
    }

    let [answerCheck, setAnswerCheck] = useState({
        1: false, 2: false, 3: false, 4: false, 5: false, 6: false, 7: false, 8: false, 9: false, 10: false,
    });

    console.log(answerCheck)

    return <>
        <div id="my">
            <MyNav setDivName={setDivName} divName={divName} userData={userData}></MyNav>
            <div className={divName}>
                <Menu divName={divName} setDivName={setDivName}></Menu>
                {memberUid !== null ? <section>
                    <a href="#"><img src={`${process.env.REACT_APP_HOME_URL}/images/my/my_banner2.png`}
                                     alt="패션, 타운 하나로 끝" className="banner"/></a>
                    {divName === 'qna' && <>
                        <article>
                            <h3>문의하기</h3>

                            <table border="0">
                                <tbody>
                                    <tr>
                                        <th style={{width:'30px'}}>번호</th>
                                        <th style={{width:'80px'}}>문의채널</th>
                                        <th style={{width:'100px'}}>문의유형</th>
                                        <th style={{width:'200px'}}>제목</th>
                                        <th style={{width:'80px'}}>작성일</th>
                                        <th style={{width:'50px'}}>상태</th>
                                    </tr>
                                    {Array.isArray(pageResponseDTO.qnaDTOS) && pageResponseDTO.qnaDTOS.map((qna, index) => {
                                        return <>
                                            <tr key={index}>
                                                <td className="no">{pageResponseDTO.total - index - pageResponseDTO.pg * 10 + 10}</td>
                                                <td className="channel">{qna.cateName}</td>
                                                <td className="type">{qna.typeName}</td>
                                                {content(qna, setAnswerCheck, index)}
                                                <td className="date">{qna.rdate.substring(0, 10)}</td>
                                                {answer(qna.answerComplete)}
                                            </tr>
                                            {qna.answerComplete === 2 && answerCheck[index] &&
                                                <tr className="answerRow" key={index + 'answer'}>
                                                    <td colSpan="6">
                                                        <div className="question">
                                                            <p className="tit">
                                                                {qna.title}
                                                                <span className="date">{qna.rdate.substring(0,10)} {qna.rdate.substring(11,20)}</span>
                                                            </p>
                                                            <p className="content">
                                                                {qna.content}
                                                            </p>
                                                        </div>
                                                        <div className="answer">
                                                            <p className="tit">
                                                                {qna.typeName} 문의 답변입니다.
                                                                <span className="date">{qna.answerDate.substring(0,10)} {qna.answerDate.substring(11,20)}</span>
                                                            </p>
                                                            <p className="content">
                                                                {qna.answer}
                                                            </p>
                                                        </div>
                                                    </td>
                                                </tr>}
                                        </>
                                    })}
                                </tbody>
                            </table>

                            <MyPageNavigation pageResponseDTO={pageResponseDTO}
                                              setPageRequestDTO={setPageRequestDTO}></MyPageNavigation>
                        </article>
                    </>}
                    {divName === 'home' && <>
                        <Latest userOrder={userOrder}></Latest>
                        <Point userPoint={userPoint}></Point>
                        <Review userReview={userReview}></Review>
                        <Qna userQna={userQna}></Qna>
                        <MyInfo></MyInfo></>}
                    {divName === 'review' && <>
                        <MyReview pageResponseDTO={pageResponseDTO}
                                  setPageRequestDTO={setPageRequestDTO}></MyReview>
                    </>}
                </section> : <section className="error" style={{
                    padding: '50px 0 !important', textAlign: 'center', fontSize: '15px',
                }}>데이터를 받아오는데 오류가 발생했습니다. 로그인 후 다시 시도해주세요.
                </section>}


            </div>
        </div>


    </>


}

export default Home;