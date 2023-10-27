import React, {useEffect, useState} from "react";
import axios from "axios";
import {useSelector} from "react-redux";
import {changeDTO} from "../../../store/changeDTO";

function ReviewWrite({item, setPopup}) {
    let [reviewRating, setReviewRating] = useState(5);
    let [content, setContent] = useState('');
    let ip = useSelector((state) => state.myIp);
    let [review, setReview] = useState({
        prodNo: item.prodNo,
        content: content,
        uid: localStorage.getItem('memberUid'),
        rating: reviewRating,
        regIp: ip,
    })
    console.log(review)
    useEffect(() => {
        changeDTO(setReview, 'content', content)
    }, [content]);
    useEffect(() => {
        changeDTO(setReview, 'rating', reviewRating)
    }, [reviewRating])
    console.log(content.length);
    return <>
        <div id="popReview" className="popup"
             style={{backgroundColor: 'rgba(0, 0, 0, 0.5)'}}>
            <div>
                <nav>
                    <h1>상품평 작성하기</h1>
                    <button className="btnClose" style={{border:'none'}} onClick={()=>{setPopup('')}}>X</button>
                </nav>
                <section>
                    <div>
                        <table border="0">
                            <tbody>
                                <tr>
                                    <th>상품명</th>
                                    <td className="productName" style={{textAlign: 'left'}}>{item.prodName}</td>
                                </tr>
                                <tr>
                                    <th>만족도</th>
                                    <td className="rating">
                                        <h5 className={reviewRating >= 1 ? "rating starOn" : "rating starOff"}
                                            style={{display: 'inline-block', float: 'left', cursor: 'pointer'}}
                                            onClick={() => {
                                                setReviewRating(1)
                                            }}></h5>
                                        <h5 className={reviewRating >= 2 ? "rating starOn" : "rating starOff"}
                                            style={{display: 'inline-block', float: 'left', cursor: 'pointer'}}
                                            onClick={() => {
                                                setReviewRating(2)
                                            }}></h5>
                                        <h5 className={reviewRating >= 3 ? "rating starOn" : "rating starOff"}
                                            style={{display: 'inline-block', float: 'left', cursor: 'pointer'}}
                                            onClick={() => {
                                                setReviewRating(3)
                                            }}></h5>
                                        <h5 className={reviewRating >= 4 ? "rating starOn" : "rating starOff"}
                                            style={{display: 'inline-block', float: 'left', cursor: 'pointer'}}
                                            onClick={() => {
                                                setReviewRating(4)
                                            }}></h5>
                                        <h5 className={reviewRating >= 5 ? "rating starOn" : "rating starOff"}
                                            style={{display: 'inline-block', float: 'left', cursor: 'pointer'}}
                                            onClick={() => {
                                                setReviewRating(5)
                                            }}></h5>
                                    </td>
                                </tr>
                                <tr>
                                    <th>내용</th>
                                    <td className="review">
                                        <textarea name="review" placeholder="내용입력" value={content} onChange={(e) => {
                                            setContent(e.target.value)
                                        }}></textarea>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <p>
                            ※ 상품평을 작성하시면 구매확정 포인트와 더불어 추가 포인트를 지급합니다.
                        </p>

                        <div>
                            <input type="submit" className="btnPositive" value="작성완료"
                                   style={{
                                       color: 'white',
                                       fontFamily: '휴먼고딕',
                                       width: '80px',
                                       height: '30px',
                                       textAlign: 'center'
                                   }} onClick={() => {
                                if (content.length > 10) {
                                    axios.post(`${process.env.REACT_APP_API_ROOT}/my/review/write`, review).catch((err) => {

                                    })
                                    setPopup('')
                                    alert('리뷰가 작성되었습니다.')
                                } else {
                                    alert('10글자 이상 작성해주세요.')
                                }

                            }}/>
                            <button
                            onClick={()=>{setPopup('')}}
                                style={{
                                color: 'white',
                                fontFamily: '휴먼고딕',
                                width: '70px',
                                height: '30px',
                                marginLeft: '10px'
                            }} className="btnNegative btnCancel">취소
                            </button>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </>
}

export default ReviewWrite;