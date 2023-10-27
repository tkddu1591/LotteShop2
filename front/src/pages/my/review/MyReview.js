import {Link} from "react-router-dom";
import ratingCheck from "../../../store/ratingCheck";
import MyPageNavigation from "../MyPageNavigation";
import React from "react";

function MyReview({pageResponseDTO, setPageRequestDTO}){
    return<>
        <article>
            <h3>나의리뷰</h3>

            <table border="0" key="myReview">
                <tbody>
                    <tr>
                        <th>번호</th>
                        <th>상품명</th>
                        <th>내용</th>
                        <th>평점</th>
                        <th>작성일</th>
                    </tr>
                    {pageResponseDTO.reviewDtoList&&pageResponseDTO.reviewDtoList.map((item, index) => {
                        return <tr key={item.revNo}>
                                <td className="no">{pageResponseDTO.total-index - pageResponseDTO.pg*10 +10}</td>
                                <td className="prodName"><Link to={`${process.env.REACT_APP_HOME_URL}/product/view?prodNo=`+item.prodNo}>{item.prodName}</Link></td>
                                <td className="content">{item.content}</td>
                                {ratingCheck(item.rating)}
                                <td className="date">{item.rdate.substring(0,10)}</td>
                            </tr>
                    })}
                < /tbody>
            </table>
            <MyPageNavigation pageResponseDTO={pageResponseDTO} setPageRequestDTO={setPageRequestDTO}></MyPageNavigation>
        </article></>
}
export default MyReview;