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
import {changeDTO} from "../../store/ChangeDTO";
import {Link} from "react-router-dom";
import PageNavigation from "../product/list/PageNavigation";
import MyPageNavigation from "./MyPageNavigation";

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
    function ratingCheck(value) {
        if (value >= 4.5)
            return <td><span className="rating star5">상품평</span></td>
        else if (value >= 3.5)
            return <td><span className="rating star4">상품평</span></td>
        else if (value >= 2.5)
            return <td><span className="rating star3">상품평</span></td>
        else if (value >= 1.5)
            return <td><span className="rating star2">상품평</span></td>
        else
            return <td><span className="rating star1">상품평</span></td>
    }

    return <>
        <div id="my">
            <MyNav setDivName={setDivName} divName={divName} userData={userData}></MyNav>
            <div className={divName}>
                <Menu divName={divName} setDivName={setDivName}></Menu>
                {memberUid !== null ? <section>
                        <a href="#"><img src={`${process.env.REACT_APP_HOME_URL}/images/my/my_banner2.png`}
                                         alt="패션, 타운 하나로 끝" className="banner"/></a>
                        {divName === 'home' && <>
                            <Latest userOrder={userOrder}></Latest>
                            <Point userPoint={userPoint}></Point>
                            <Review userReview={userReview}></Review>
                            <Qna userQna={userQna}></Qna>
                            <MyInfo></MyInfo></>}
                        {divName === 'review' && <>
                            <article>
                                <h3>나의리뷰</h3>

                                <table border="0">
                                    <tbody>
                                        <tr>
                                            <th>번호</th>
                                            <th>상품명</th>
                                            <th>내용</th>
                                            <th>평점</th>
                                            <th>작성일</th>
                                        </tr>
                                        {pageResponseDTO.reviewDtoList&&pageResponseDTO.reviewDtoList.map((item, index) => {
                                            console.log(pageResponseDTO.total-index)
                                            return <>
                                                <tr key={index}>
                                                    <td className="no">{pageResponseDTO.total-index - pageResponseDTO.pg*10 +10}</td>
                                                    <td className="prodName"><Link to={`${process.env.REACT_APP_HOME_URL}/product/view?prodNo=`+item.prodNo}>{item.prodName}</Link></td>
                                                    <td className="content">{item.content}</td>
                                                    {ratingCheck(item.rating)}
                                                    <td className="date">{item.rdate.substring(0,10)}</td>
                                                </tr>


                                            </>
                                        })}
                                    < /tbody>
                                </table>
                                <MyPageNavigation pageResponseDTO={pageResponseDTO} setPageRequestDTO={setPageRequestDTO}></MyPageNavigation>
                            </article>
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