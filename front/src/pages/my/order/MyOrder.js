import DateSelect from "../DateSelect";
import MyPageNavigation from "../MyPageNavigation";
import React, {useState} from "react";
import {useNavigate} from "react-router-dom";
import ReviewWrite from "../ReviewWrite";
import axios from "axios";

function MyOrder({pageResponseDTO, setPageRequestDTO}) {
    function orderComplete(value) {
        if (value === 4)
            return <td className="status" style={{color: 'green'}}>배송완료</td>
        else if (value === 1)
            return <td className="status">배송중</td>
        else if (value === 2)
            return <td className="status" style={{color: 'red'}}>결제대기</td>

        else
            return <td className="status" style={{color: 'red'}}>주문취소</td>
    }

    let navigate = useNavigate();
    let [reviewWrite, setReviewWrite] = useState('');
    return <>
        <article>
            <h3>전체주문내역</h3>
            <DateSelect setPageRequestDTO={setPageRequestDTO}></DateSelect>
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
                                    <li className="company">{item.company}</li>
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

                                {item.ordComplete === 4 ? <>
                                        <a onClick={() => {
                                            setReviewWrite(index)
                                        }} className="review">상품평</a>
                                        <a className="refund">반품신청</a>
                                        <a className="exchange">교환신청</a>
                                        <a className="exchange">재주문</a>
                                    </> :
                                    item.ordComplete !== 3 && <>
                                        <a className="receive">수취확인</a>
                                        <a className="exchange" onClick={() => {
                                            /* eslint-disable no-restricted-globals */
                                            if (confirm('주문을 취소하시겠습니까?')) {
                                                axios.delete(`${process.env.REACT_APP_API_ROOT}/product/order/delete`, {
                                                    params: {ordNo: item.ordNo}
                                                }).then(
                                                    res => {
                                                        alert('주문이 취소되었습니다.')
                                                    }
                                                ).catch(err => {
                                                    console.log(err)
                                                })
                                            }
                                        }}>주문취소</a>
                                    </>
                                }
                            </td>
                            {reviewWrite === index && item.ordComplete === 4 &&
                                <ReviewWrite setReviewWrite={setReviewWrite} item={item}></ReviewWrite>}
                        </tr>
                    })}

                </tbody>
            </table>
            <MyPageNavigation setPageRequestDTO={setPageRequestDTO}
                              pageResponseDTO={pageResponseDTO}></MyPageNavigation>
        </article>
    </>
}

export default MyOrder