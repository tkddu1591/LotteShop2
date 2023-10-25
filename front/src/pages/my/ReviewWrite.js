import React, {useEffect, useState} from "react";
import axios from "axios";
import {useSelector} from "react-redux";
import {changeDTO} from "../../store/changeDTO";

function ReviewWrite({item, setReviewWrite}) {
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
    useEffect(() => {
        changeDTO(setReview, 'content', content)
    }, [content]);
    useEffect(()=>{
        changeDTO(setReview, 'rating', reviewRating)
    },[reviewRating])
    console.log(content.length);
    return <>
        <div style={{
            position: 'fixed',
            width: '100%',
            top: '0',
            left: '0',
            height: '100%',
            zIndex: '100',

            background: 'rgba(0, 0, 0, 0.5)',
        }}>
            <div
                style={{
                    width: '50%',
                    transform: 'translate(50%,30%)',
                    position: 'absolute',
                    backgroundColor: 'white',
                    height: '400px',
                    padding: '20px',
                    boxShadow: '5px 5px 5px'
                }}
            >
                <div style={{width: '100%', height: '20px', backgroundColor: 'white'}}><p className='close'
                                                                                          onClick={(e) => {
                                                                                              setReviewWrite(null)
                                                                                          }}/></div>

                <img src="https://via.placeholder.com/80x80"
                     alt="" style={{position: 'relative', display: 'inline-block', float: 'left'}}/>
                <div style={{
                    display: 'inline-block',
                    position: 'relative',
                    float: 'left',
                    marginLeft: '10px'
                }}>
                    <p style={{fontSize: '17px'}}>상품명 : {item.prodName}</p>
                    <p style={{color: 'gray', marginTop: '3px'}}>배송일자 : {item.ordCompleteDate.substring(0, 10)}</p>
                    <p style={{
                        color: 'blue',
                        marginTop: '3px'
                    }}>\ {(item.price - (item.price * item.discount) / 100).toLocaleString()} </p>
                    <div style={{marginTop: '5px'}}>
                        <h5 className={reviewRating >= 1 ? "rating starOn" : "rating starOff"}
                            style={{display: 'inline-block', float: 'left', cursor: 'pointer'}} onClick={() => {
                            setReviewRating(1)
                        }}></h5>
                        <h5 className={reviewRating >= 2 ? "rating starOn" : "rating starOff"}
                            style={{display: 'inline-block', float: 'left', cursor: 'pointer'}} onClick={() => {
                            setReviewRating(2)
                        }}></h5>
                        <h5 className={reviewRating >= 3 ? "rating starOn" : "rating starOff"}
                            style={{display: 'inline-block', float: 'left', cursor: 'pointer'}} onClick={() => {
                            setReviewRating(3)
                        }}></h5>
                        <h5 className={reviewRating >= 4 ? "rating starOn" : "rating starOff"}
                            style={{display: 'inline-block', float: 'left', cursor: 'pointer'}} onClick={() => {
                            setReviewRating(4)
                        }}></h5>
                        <h5 className={reviewRating >= 5 ? "rating starOn" : "rating starOff"}
                            style={{display: 'inline-block', float: 'left', cursor: 'pointer'}} onClick={() => {
                            setReviewRating(5)
                        }}></h5>
                    </div>
                </div>
                <div style={{
                    display: 'inline-block',
                    position: 'relative',
                    float: 'right',
                }}>
                    <br/>
                    <br/>
                    <br/>
                    <button style={{width: '100px', height: '30px'}}

                            onClick={() => {
                                if (content.length > 10) {
                                    axios.post(`${process.env.REACT_APP_API_ROOT}/my/review/write`, review).catch((err) => {
                                        console.log(err)

                                    })
                                    setReviewWrite(null)
                                    alert('리뷰가 작성되었습니다.')
                                } else {
                                    alert('10글자 이상 작성해주세요.')
                                }

                            }}
                    >리뷰 작성
                    </button>
                </div>

                <textarea
                    placeholder="10글자 이상 작성해주세요"
                    style={{
                        marginTop: '10px',
                        resize: "none",
                        position: 'relative',
                        width: '94%',
                        height: '64%',
                        border: '1px solid gray',
                        fontSize: '16px',
                        padding: '3%',
                        fontFamily: 'Helvetica',
                        caretColor: 'black'
                    }} value={content}
                    onChange={(e) => {
                        console.log(e.target.value)
                        setContent(e.target.value)
                    }}

                />

            </div>
        </div>
    </>
}

export default ReviewWrite;