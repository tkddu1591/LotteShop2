import DateSelect from "../DateSelect";
import MyPageNavigation from "../MyPageNavigation";
import React, {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import ReviewWrite from "../ReviewWrite";
import axios from "axios";
import ReviewWrite2 from "./ReviewWrite2";
import PopReceive from "./PopReceive";
import OrderList from "./OrderList";
import {member} from "../../../slice/memberSlice";

function MyOrder({
                     pageResponseDTO,
                     setPageRequestDTO,
                     popup,
                     setPopup,
                     setOrderItem,
                     setReviewWrite,
                     orderItem,
                     reviewWrite,
                     divName,
                     setDivName,
                     member
                 }) {

    if (divName === 'order') {
        return <>
            <article className="latest">
                <h3>전체주문내역</h3>
                <DateSelect setPageRequestDTO={setPageRequestDTO}></DateSelect>
                <OrderList setPopup={setPopup} orderItem={orderItem} setOrderItem={setOrderItem}
                           setPageRequestDTO={setPageRequestDTO} pageResponseDTO={pageResponseDTO}
                           popup={popup} member={member}
                           setReviewWrite={setReviewWrite}></OrderList>

                {/*<ReviewWrite2 setReviewWrite={setReviewWrite} item={orderItme}></ReviewWrite2>*/}
                <MyPageNavigation setPageRequestDTO={setPageRequestDTO}
                                  pageResponseDTO={pageResponseDTO}></MyPageNavigation>

            </article>
        </>
    } else
        return <>
            <article className="latest">
                <h3>최근주문내역</h3>

                <a onClick={() => {
                    setDivName('order')
                }} className="more">더보기</a>
                <OrderList setPopup={setPopup} orderItem={orderItem} setOrderItem={setOrderItem}
                           setPageRequestDTO={setPageRequestDTO} pageResponseDTO={pageResponseDTO}
                           popup={popup} member={member}
                           setReviewWrite={setReviewWrite}></OrderList>

            </article>
        </>
}


export default MyOrder