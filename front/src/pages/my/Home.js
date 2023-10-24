import MyNav from "./myNav";
import React, {useEffect, useState} from "react";
import axios from "axios";
import {API_BASE_URL} from "../../App";
import Menu from "./home/Menu";
import Latest from "./home/Latest";
import Point from "./home/Point";
import Review from "./home/Review";
import Qna from "./home/Qna";
import MyInfo from "./home/MyInfo";
import {createTokenHeader, retrieveStoredToken} from "../../slice/tokenSlice";
import {changeDTO} from "../../store/changeDTO";
import MyReview from "./review/MyReview";

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
                                            <th>번호</th>
                                            <th>문의채널</th>
                                            <th>문의유형</th>
                                            <th>제목</th>
                                            <th>작성일</th>
                                            <th>상태</th>
                                        </tr>
                                        <tr>
                                            <td className="no">5</td>
                                            <td className="channel">고객센터</td>
                                            <td className="type">주문/결제</td>
                                            <td className="tit"><a href="#">신용카드 결제 중 오류가 난 경우 어떻게 하나요?</a></td>
                                            <td className="date">2024-12-12</td>
                                            <td className="status"><span className="notAnswerYet">검토중</span></td>
                                        </tr>
                                        <tr>
                                            <td className="no">4</td>
                                            <td className="channel">고객센터</td>
                                            <td className="type">주문/결제</td>
                                            <td className="tit"><a href="#">신용카드 결제 중 오류가 난 경우 어떻게 하나요?</a></td>
                                            <td className="date">2024-12-12</td>
                                            <td className="status"><span className="answered">답변완료</span></td>
                                        </tr>
                                        <tr className="answerRow">
                                            <td colSpan="6">
                                                <div className="question">
                                                    <p className="tit">
                                                        신용카드 결제 중 오류가 난 경우 어떻게 하나요?
                                                        <span className="date">2022-12-16 10:08:25</span>
                                                    </p>
                                                    <p className="content">
                                                        결제하다가 오류가 나서 결제가 안됩니다.
                                                    </p>
                                                </div>
                                                <div className="answer">
                                                    <p className="tit">
                                                        주문/결제 문의 답변입니다.
                                                        <span className="date">2022-12-17 10:08:25</span>
                                                    </p>
                                                    <p className="content">
                                                        다른 카드로 결제 하세요. 그러면 될거에요.
                                                    </p>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td className="no">3</td>
                                            <td className="channel">판매자게시판</td>
                                            <td className="type">배송</td>
                                            <td className="tit">
                                                <ul>
                                                    <li className="prodName"><a href="#">상품명</a></li>
                                                    <li className="question"><a href="#">배송기간이 보통 얼마나 걸리나요?</a></li>
                                                </ul>
                                            </td>
                                            <td className="date">2024-12-12</td>
                                            <td className="status"><span className="answered">답변완료</span></td>
                                        </tr>
                                        <tr className="answerRow">
                                            <td colSpan="6">
                                                <div className="question">
                                                    <p className="tit">
                                                        배송기간이 보통 얼마나 걸리나요?
                                                        <span className="date">2022-12-16 10:08:25</span>
                                                    </p>
                                                    <p className="content">
                                                        알고싶어요. 알려주세요.
                                                    </p>
                                                </div>
                                                <div className="answer">
                                                    <p className="tit">
                                                        배송 문의 답변입니다.
                                                        <span className="date">2022-12-17 10:08:25</span>
                                                    </p>
                                                    <p className="content">
                                                        보통 한달 걸립니다.
                                                    </p>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td className="no">2</td>
                                            <td className="channel">판매자게시판</td>
                                            <td className="type">상품</td>
                                            <td className="tit">
                                                <ul>
                                                    <li className="prodName"><a href="#">상품명</a></li>
                                                    <li className="question"><a href="#">흰색 상품은 없나요?</a></li>
                                                </ul>
                                            </td>
                                            <td className="date">2024-12-12</td>
                                            <td className="status"><span className="answered">답변완료</span></td>
                                        </tr>
                                        <tr className="answerRow">
                                            <td colSpan="6">
                                                <div className="question">
                                                    <p className="tit">
                                                        흰색 상품은 없나요?
                                                        <span className="date">2022-12-16 10:08:25</span>
                                                    </p>
                                                    <p className="content">
                                                        흰색 살래요~
                                                    </p>
                                                </div>
                                                <div className="answer">
                                                    <p className="tit">
                                                        상품 문의 답변입니다.
                                                        <span className="date">2022-12-17 10:08:25</span>
                                                    </p>
                                                    <p className="content">
                                                        네 없어요.
                                                    </p>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td className="no">1</td>
                                            <td className="channel">판매자게시판</td>
                                            <td className="type">반품</td>
                                            <td className="tit">
                                                <ul>
                                                    <li className="prodName"><a href="#">상품명</a></li>
                                                    <li className="question"><a href="#">사이즈가 너무 작아요. 반품 요청합니다.</a></li>
                                                </ul>
                                            </td>
                                            <td className="date">2024-12-12</td>
                                            <td className="status"><span className="answered">답변완료</span></td>
                                        </tr>
                                        <tr className="answerRow">
                                            <td colSpan="6">
                                                <div className="question">
                                                    <p className="tit">
                                                        사이즈가 너무 작아요. 반품 요청합니다.
                                                        <span className="date">2022-12-16 10:08:25</span>
                                                    </p>
                                                    <p className="content">
                                                        반품 해주세요.
                                                    </p>
                                                </div>
                                                <div class="answer">
                                                    <p class="tit">
                                                        반품 문의 답변입니다.
                                                        <span class="date">2022-12-17 10:08:25</span>
                                                    </p>
                                                    <p class="content">
                                                        반품 안돼요.
                                                    </p>
                                                </div>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>

                                <p class="page">
                                    <a href="#" class="prev">이전</a>
                                    <a href="#" class="num on">1</a>
                                    <a href="#" class="num">2</a>
                                    <a href="#" class="num">3</a>
                                    <a href="#" class="next">다음</a>
                                </p>
                            </article>
                        </>}
                        {divName === 'home' && <>
                            <Latest userOrder={userOrder}></Latest>
                            <Point userPoint={userPoint}></Point>
                            <Review userReview={userReview}></Review>
                            <Qna userQna={userQna}></Qna>
                            <MyInfo></MyInfo></>}
                        {divName === 'review' && <>
                            <MyReview pageResponseDTO={pageResponseDTO} setPageRequestDTO={setPageRequestDTO}></MyReview>
                        </>}
                    </section>
                    :
                    <section className="error" style={{
                        padding: '50px 0 !important', textAlign: 'center', fontSize: '15px',
                    }}>데이터를 받아오는데 오류가 발생했습니다. 로그인 후 다시 시도해주세요.
                    </section>
                }


            </div>
        </div>


    </>


}

export default Home;