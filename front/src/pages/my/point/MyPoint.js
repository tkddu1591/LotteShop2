import MyPageNavigation from "../MyPageNavigation";
import React from "react";
import {
    divisionCheck,
} from "../../../store/dateChange";
import DateSelect from "../DateSelect";

function MyPoint({pageResponseDTO, setPageRequestDTO}){


    return<>
        <article>
            <h3>포인트내역</h3>

            <DateSelect setPageRequestDTO={setPageRequestDTO}></DateSelect>
            <table border="0">
                <tbody>
                    <tr>
                        <th>날짜</th>
                        <th>구분</th>
                        <th>주문번호</th>
                        <th>금액</th>
                        <th>비고</th>
                        <th>유효기간</th>
                    </tr>
                    {Array.isArray(pageResponseDTO.pointDTOS) &&
                        pageResponseDTO.pointDTOS.map((item, index) => {
                            return <tr key={item.pointNo}>
                                <td className="date">{item.ordDate.substring(0, 10)}</td>
                                {divisionCheck(item.pointDate)}
                                <td className="ordNo">{item.ordNo}</td>
                                <td className="point">{item.point} P</td>
                                <td className="desc">{item.comment ? item.comment : item.ordNo + '번 주문에 사용'}</td>
                                <td className="expire">{item.pointDate ? item.pointDate.substring(0, 10) : '-'}</td>
                            </tr>
                        })
                    }
                </tbody>
            </table>

            <MyPageNavigation pageResponseDTO={pageResponseDTO} setPageRequestDTO={setPageRequestDTO}></MyPageNavigation>
        </article></>
}
export default MyPoint;