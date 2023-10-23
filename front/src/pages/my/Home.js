import {Route} from "react-router-dom";
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
import Error from "../product/order/Error";

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
    useEffect(() => {
        if (memberUid !== null) {
            if (memberUid !== null && retrieveStoredToken().token != null) {
                axios.get(`${API_BASE_URL}/member/me`, createTokenHeader(retrieveStoredToken().token))
                    .then(response => {
                        setUserData(response.data)
                    }).catch(error => console.log('유저 정보가 없습니다.'))
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
                    pg: 1,
                    size: 5,
                    type: 'qna',
                    memberUid: memberUid
                }
            })
                .then(res => {
                    setUserQnA(res.data.qnaDTOS)
                }).catch(error => {
                console.log(error);
            })
        }
    }, [pageRequestDTO]);
    let [divName, setDivName] = useState('home');
    console.log(userPoint)
    console.log(userOrder)
    console.log(userReview)
    console.log(userQna)
    console.log(userData)

    return <>
        <div id="my">
            <MyNav setDivName={setDivName} divName={divName} userData={userData}></MyNav>
            <div className={divName}>
                <Menu></Menu>
                {memberUid !== null ?
                    <section>
                        <a href="#"><img src={`${process.env.REACT_APP_HOME_URL}/images/my/my_banner2.png`}
                                         alt="패션, 타운 하나로 끝" className="banner"/></a>
                        <Latest userOrder={userOrder}></Latest>
                        <Point userPoint={userPoint}></Point>
                        <Review userReview={userReview}></Review>
                        <Qna userQna={userQna}></Qna>
                        <MyInfo></MyInfo>
                    </section>
                :<section className="error" style={{
                        padding: '50px 0 !important',
                        textAlign: 'center',
                        fontSize: '15px',
                    }}>데이터를 받아오는데 오류가 발생했습니다. 로그인 후 다시 시도해주세요.</section>}


            </div>
        </div>


    </>


}

export default Home;