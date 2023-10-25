import React from "react";

function Review({userReview, setDivName}) {

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
        <article className="review">
            <h3>상품평</h3>
            <a onClick={()=>{setDivName('review')}} className="more">더보기</a>
            <table border="0">
                <tbody>
                    <tr>
                        <th>상품명</th>
                        <th style={{width: '300px'}}>내용</th>
                        <th>평점</th>
                        <th>작성일</th>
                    </tr>
                    {userReview.map((item, index) => {
                        return <tr key={index+item.prodNo}>
                                <td>{item.prodName}</td>
                                <td>{item.content}</td>
                                {ratingCheck(item.rating)}
                                <td>{item.rdate.substring(0, 10)}</td>
                            </tr>
                    })}
                </tbody>
            </table>
        </article>
    </>
}

export default Review;