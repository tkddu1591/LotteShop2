import {useNavigate} from "react-router-dom";
import axios from "axios";
import React from "react";
import PopReceive from "./PopReceive";
import ReviewWrite2 from "./ReviewWrite2";
import SellerData from "./SellerData";
import QnaPopup from "./QnaPopup";

function OrderList({
                       pageResponseDTO,
                       setPopup,
                       setOrderItem,
                       orderItem,
                       popup,
                       member
                   }) {
    let navigate = useNavigate();

    function orderComplete(value) {
        if (value === 4)
            return <td className="status" style={{color: 'green'}}>배송완료</td>
        else if (value === 5)
            return <td className="status" style={{color: 'green'}}>수취확인</td>
        else if (value === 1)
            return <td className="status">배송중</td>
        else if (value === 2)
            return <td className="status" style={{color: 'red'}}>결제대기</td>

        else
            return <td className="status" style={{color: 'red'}}>주문취소</td>
    }


    function confirmApply(value) {
        if (value === 3) {
            return
        }
    }


    return <>
        <table border="0">
            <tbody>
                <tr>
                    <th>날짜</th>
                    <th>상품정보</th>
                    <th>상태</th>
                    <th>확인/신청</th>
                </tr>
                {Array.isArray(pageResponseDTO.orderItemDTOS) && pageResponseDTO.orderItemDTOS.map((item, index) => {

                    return <tr key={item.orderItemId}>
                        <td className="date">{item.ordDate.substring(0, 10)}</td>
                        <td>
                            <a onClick={() => {
                                navigate("/product/view?prodNo=" + item.prodNo)
                            }} className="thumb"><img
                                src="https://via.placeholder.com/80x80"
                                alt={item.thumb1}/></a>
                            <ul>
                                <li className="company" style={{cursor: 'pointer'}} onClick={() => {
                                    setPopup('seller')
                                    setOrderItem(item)
                                }}>{item.company}</li>
                                <li className="prodName"><a onClick={() => {
                                    navigate("/product/view?prodNo=" + item.prodNo)
                                }}>{item.prodName}</a></li>
                                <li>수량 : <span className="prodCount">{item.count}</span>개 / 주문번호 : <span
                                    className="ordNo">{item.ordNo}</span></li>
                                <li className="prodPrice">{(item.price - (item.price * item.discount) / 100).toLocaleString()}</li>
                            </ul>
                        </td>
                        {orderComplete(item.ordComplete)}
                        <td className="confirm">

                            {(item.ordComplete === 5) ? <>
                                    <a onClick={() => {
                                        setOrderItem(item)
                                        setPopup('review')
                                    }} className="review">상품평</a>
                                    <a className="exchange">재주문</a>
                                </> :
                                item.ordComplete !== 3 && <>
                                    {item.ordComplete !== 5 && item.ordComplete !== 2 &&
                                        <a className="receive" onClick={() => {
                                            /* eslint-disable no-restricted-globals */
                                            setPopup('receive')
                                            setOrderItem(item)
                                        }}>수취확인</a>}
                                    <a className="refund" onClick={() => {
                                        setOrderItem(item)
                                        setPopup('qna')
                                    }} >문의하기</a>
                                </>
                            }
                        </td>

                    </tr>

                })}

            </tbody>
        </table>

        {popup === 'review' &&
            <ReviewWrite2 setPopup={setPopup} item={orderItem}></ReviewWrite2>}
        {popup === 'receive' && <PopReceive setPopup={setPopup} item={orderItem}></PopReceive>}
        {popup === 'seller' && <SellerData setPopup={setPopup} item={orderItem}></SellerData>}
        {popup === 'qna' && <QnaPopup setPopup={setPopup} item={orderItem} member={member}></QnaPopup>}
    </>

}

export default OrderList