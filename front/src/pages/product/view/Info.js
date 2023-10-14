import {useState} from "react";

function Info({prodDTO, scrollY, changeProdDTO}) {

    function scrollToYPosition(scrollY) {
        window.scrollTo({
            top: scrollY, behavior: 'smooth'
        });
        console.log(scrollY);
    }

    let score = prodDTO.score;

    function changeDiscountPrice(price, discount) {
        return (price - (discount * price / 100))
    }

    function checkScore(score) {
        if (score == 0) {
            return <h5>상품평이 없습니다.</h5>
        } else if (score > 4.5) {
            return <h5 className="rating star5"><a onClick={(e) => scrollToYPosition(scrollY)}
                                                   style={{cursor: 'pointer', userSelect: 'none'}}>상품평보기</a></h5>
        } else if (score > 3.5) {
            return <h5 className="rating star4"><a onClick={(e) => scrollToYPosition(scrollY)}
                                                   style={{cursor: 'pointer', userSelect: 'none'}}>상품평보기</a></h5>
        } else if (score > 2.5) {
            return <h5 className="rating star3"><a onClick={(e) => scrollToYPosition(scrollY)}
                                                   style={{cursor: 'pointer', userSelect: 'none'}}>상품평보기</a></h5>
        } else if (score > 1.5) {
            return <h5 className="rating star2"><a onClick={(e) => scrollToYPosition(scrollY)}
                                                   style={{cursor: 'pointer', userSelect: 'none'}}>상품평보기</a></h5>
        } else {
            return <h5 className="rating star1"><a onClick={(e) => scrollToYPosition(scrollY)}
                                                   style={{cursor: 'pointer', userSelect: 'none'}}>상품평보기</a></h5>
        }
    }

    function addDays(date, days) {
        const clone = new Date(date);
        clone.setDate(date.getDate() + days)
        return clone;
    }

    const today = new Date();
    const deliveryDay = addDays(today, 2);
    const week = ['일', '월', '화', '수', '목', '금', '토', '일', '월', '화']
    let dayOfWeef = week[deliveryDay.getDay()]

    function changeFommatDate() {
        return '모레(' + dayOfWeef + ')   ' + ('0' + (deliveryDay.getMonth() + 1)).slice(-2) + '/' + ('0' + deliveryDay.getDate()).slice(-2) + ' 도착예정';
        ;
    }

    let [count, setCount] = useState(1)
    const handleInputChange = (event) => {
        const updateCount = event.target.value
        if (isNaN (Number(updateCount))) {
            setCount(1);
        }else{
            setCount(updateCount);
        }
        if (updateCount > prodDTO.stock) {
            setCount(prodDTO.stock);
        } else if (updateCount < 1) {
            setCount(1);
        }
    };
    return <>
        <article className="info">
            <div className="image">
                <img src="https://via.placeholder.com/460x460" alt="상품이미지"/>
            </div>
            <div className="summary">
                <nav>
                    <h1>{prodDTO.company}</h1>
                    <h2>상품번호&nbsp;:&nbsp;<span>{prodDTO.prodNo}</span></h2>
                </nav>
                <nav>
                    <h3>{prodDTO.prodName}</h3>
                    <p>{prodDTO.descript}</p>
                    {checkScore(prodDTO.score)}
                </nav>
                <nav>
                    {prodDTO.discount === 0 ? '' : <div className="org_price">
                        <del>{prodDTO.price.toLocaleString()}</del>
                        <span>{prodDTO.discount}%</span>
                    </div>}
                    <div className="dis_price">
                        <ins>{prodDTO.discount === 0 ? prodDTO.price.toLocaleString() : changeDiscountPrice(prodDTO.price, prodDTO.discount).toLocaleString()}</ins>
                    </div>
                </nav>
                <nav>
                    <span
                        className="delivery">{prodDTO.delivery === 0 ? '무료배송' : prodDTO.delivery.toLocaleString() + '원'}</span>
                    <span className="arrival">{changeFommatDate()}</span>
                    <span className="desc">본 상품은 국내배송만 가능합니다.</span>
                </nav>
                <nav>
                    <span className="card cardfree"><i>아이콘</i>무이자할부</span>&nbsp;&nbsp;
                    <span className="card cardadd"><i>아이콘</i>카드추가혜택</span>
                </nav>
                <nav>
                    <span className="origin">원산지-상세설명 참조</span>
                </nav>
                <img src="../images/vip_plcc_banner.png" alt="100원만 결제해도 1만원 적립!" className="banner"/>

                <div className="count">
                    {count !== 1 ? <button className="decrease" onClick={() => {
                        if (count <= 1) {
                            setCount(1);
                        } else {
                            setCount(count - 1);
                        }
                    }}
                                           style={{cursor: 'pointer', userSelect: 'none'}}
                    >-</button> : ''}

                    <input type="text" name="num"
                           value={count}
                           onChange={handleInputChange}
                    />
                    <button className="increase" onClick={() => {
                        if (count >= prodDTO.stock) {
                            setCount(prodDTO.stock);
                        } else {
                            setCount(count + 1);
                        }

                    }}
                            style={{cursor: 'pointer', userSelect: 'none'}}
                    >+
                    </button>
                </div>

                <div className="total">
                    <span>{(count * changeDiscountPrice(prodDTO.price, prodDTO.discount)).toLocaleString()}</span>
                    <em>총 상품금액</em>
                </div>

                <div className="button">
                    <input type="button" className="cart" value="장바구니"/>
                    <input type="button" className="order" value="구매하기"/>
                </div>
            </div>
        </article>
    </>
}

export default Info;