import MyNav from "./myNav";
import React, {useEffect, useState} from "react";
import axios from "axios";
import {API_BASE_URL} from "../../App";
import Menu from "./Menu";
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
import MyRegister from "./config/MyRegister";

function Home() {
    let [popup, setPopup] = useState('');
    let [userData, setUserData] = useState({});
    let [userOrder, setUserOrderItems] = useState([])
    let [userPoint, setUserPoint] = useState([])
    let [userReview, setUserReview] = useState([])
    let [member, setMember] = useState({})
    let [userQna, setUserQnA] = useState([])
    let memberUid = localStorage.getItem('memberUid');

    let [reviewWrite, setReviewWrite] = useState(false);
    let [orderItem, setOrderItem] = useState({});
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
        //유저 오더 들고오기
        axios.get(`${API_BASE_URL}/my/list`, {
            params: {pg: 1, size: 3, type: 'order', memberUid: memberUid}
        })
            .then(res => {
                setUserOrderItems(res.data)
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
    }, [pageRequestDTO, popup, memberUid]);
    useEffect(() => {
        changeDTO(setPageRequestDTO, 'type', divName)
        changeDTO(setPageRequestDTO, 'pg', 1)
    }, [divName]);
    useEffect(() => {
        if (memberUid !== null) {
            if (retrieveStoredToken().token !== null) {

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
                    setUserOrderItems(res.data)
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
        }
    }, [memberUid]);

    return <>

        <div id="my">

            <MyNav setDivName={setDivName} divName={divName} userData={userData}></MyNav>
            <div className={divName}>
                <Menu divName={divName} setDivName={setDivName}></Menu>
                {memberUid !== null ? <section>
                    <a href={process.env.REACT_APP_HOME_URL}><img src={`${process.env.REACT_APP_HOME_URL}/images/my/my_banner2.png`}
                                     alt="패션, 타운 하나로 끝" className="banner"/></a>
                    {divName === 'info' && <>
                        <article>

                            <MyRegister setDivName={setDivName} member={member} userRegisterType='USER'></MyRegister>
                        </article>
                    </>}
                    {divName === 'order' && <>
                        <MyOrder setPageRequestDTO={setPageRequestDTO} pageResponseDTO={pageResponseDTO}
                                 setPopup={setPopup} popup={popup} setOrderItem={setOrderItem}
                                 setReviewWrite={setReviewWrite} orderItem={orderItem} reviewWrite={reviewWrite}
                                 divName={divName} member={member}
                        ></MyOrder>
                    </>}
                    {divName === 'point' && <>
                        <MyPoint setPageRequestDTO={setPageRequestDTO} pageResponseDTO={pageResponseDTO}></MyPoint>
                    </>}
                    {divName === 'coupon' && <>
                        <MyCoupon pageResponseDTO={pageResponseDTO} setPageRequestDTO={setPageResponseDTO}
                                  userData={userData}></MyCoupon>
                    </>}
                    {divName === 'qna' && <>
                        <MyQna pageResponseDTO={pageResponseDTO} setPageRequestDTO={setPageRequestDTO} setPopup={setPopup}></MyQna>
                    </>}
                    {divName === 'home' && <>
                        <MyOrder setPageRequestDTO={setPageRequestDTO} pageResponseDTO={userOrder}
                                 setPopup={setPopup} popup={popup} setOrderItem={setOrderItem}
                                 setReviewWrite={setReviewWrite} orderItem={orderItem} reviewWrite={reviewWrite}
                                 divName={divName} setDivName={setDivName} member={member}
                        ></MyOrder>
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