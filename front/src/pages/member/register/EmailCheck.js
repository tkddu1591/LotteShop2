import React, {useEffect, useState} from "react";
import axios from "axios";
import {API_BASE_URL} from "../../../App";

function EmailCheck({errors, watch, register}) {
    let [emailText, setEmailText] = React.useState("");
    let [timer, setTimer] = useState(false);
    let [emailCheck, setEmailCheck] = useState(false);

    function emailStyle() {
        if (errors.email) {
            if (emailCheck)
                setEmailCheck(false)
            if (timer) {
                setTimer(false)
            }
            if (emailText === '인증번호 재전송') {
                setEmailText('인증번호 전송')
            }
            return {display: "none"};
        } else if (emailText === "인증번호 전송")
            return {
                border: "2px outset #5E8ED0FF",
                width: '120px', height: '35px',
                fontSize: '12px',
                verticalAlign: 'middle', marginLeft: '10px', background: 'none'
            }
        else if (emailText === "인증번호 재전송")
            return {
                border: "2px outset #71D96AFF",
                width: '120px', height: '35px',
                fontSize: '12px',
                verticalAlign: 'middle', marginLeft: '10px', background: 'none'
            }
        else {
            if (emailCheck)
                setEmailCheck(false)
            if (timer) {
                setTimer(false)
            }
            return {
                display: 'none'
            }
        }
    }

    function sendEmail() {
        axios.post(`${API_BASE_URL}/member/email`, {email: watch('email')}).then(
            (response) => {
                setCode(response.data)
            }
        )
    }

    console.log(emailText)


    const MINUTES_IN_MS = 3 * 60 * 1000;
    const INTERVAL = 1000;
    const [timeLeft, setTimeLeft] = useState(MINUTES_IN_MS);

    let [code, setCode] = useState('1');
    let [emailTimeout, setEmailTimeout] = useState(true);
    let [lastEmail, setLastEmail] = useState("");
    return <tr>
        <th><span className="essential">*</span>EMAIL</th>
        <td><input type="email" name="km_email" placeholder="이메일 입력"
                   {...register("email", {
                       required: "이메일을 입력해 주세요.",
                       pattern: {
                           value: /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/ || ((setEmailText(''))),
                           message: '유효한 이메일을 입력해주세요',
                       },
                       validate: {
                           value: async (value) => {

                               if (value !== lastEmail) {
                                   let test;
                                   await axios.post(`${process.env.REACT_APP_API_ROOT}/member/checkEmail`, {email: value})
                                       .then((response) => {
                                           test = response.data;
                                       }).catch(error => {
                                           console.log(error)
                                       })
                                   if (test !== 0) {
                                       setTimer(false)
                                       setEmailText('')
                                       return '중복된 이메일이 있습니다.'
                                   } else {
                                       setLastEmail(value)
                                       setEmailText('인증번호 전송')
                                       setTimer(false)
                                   }
                               }
                           },
                       }
                   })}
                   style={(errors.email) && {border: 'solid 2px red'}}
                   required/>
            <input type="button" value={emailText} readOnly
                   style={emailStyle()}
                   onClick={() => {
                       setTimeLeft(MINUTES_IN_MS)
                       if (emailCheck)
                           return null;
                       else if (emailText === "인증번호 전송") {
                           sendEmail()
                           alert('이메일이 전송되었습니다. 확인해주세요')
                       } else {
                           // eslint-disable-next-line no-restricted-globals
                           if (!confirm('인증번호를 재전송 하시겠습니까?')) {
                               return null;
                           } else {
                               sendEmail()
                               setEmailText("인증번호 재전송")
                               setTimeLeft(MINUTES_IN_MS);
                           }
                       }
                       setEmailText("인증번호 재전송")
                       setTimer(true)
                   }}/>
            <input type='hidden' {...register('emailCheck', {
                validate: {
                    value: async (value) => {
                        if(!emailCheck)
                            return '이메일 인증을 해주세요.';
                    },
                }
            })}/>
            {timer && <Timer setEmailTimeout={setEmailTimeout} emailTimeout={emailTimeout}
                             MINUTES_IN_MS={MINUTES_IN_MS} INTERVAL={INTERVAL} timeLeft={timeLeft}
                             setTimeLeft={setTimeLeft} emailChecked={emailCheck}/>}
            {errors.email && <div style={{color: 'red'}}>{errors.email.message}</div>}
            <br/>
            {emailText !== '' && !errors.email && timer && code !== '' &&
                <input type="text" name="km_email"
                       placeholder="인증번호 입력"
                       {...register("emailCheck", {
                           validate: {
                               value: async (value) => {
                                   if (!emailTimeout) {
                                       setEmailCheck(false)
                                       return '인증번호 시간이 만료되었습니다.'
                                   } else if (value !== code) {
                                       setEmailCheck(false)
                                       return '인증번호가 일치하지 않습니다.'
                                   } else {
                                       setEmailCheck(true)
                                   }
                               },
                           }
                       })}
                       style={errors.emailCheck && {border: 'solid 2px red'}}
                       required/>}
            {errors.emailCheck && !errors.email && <div style={{color: 'red'}}>{errors.emailCheck.message}</div>}
            {emailCheck && !errors.email && <div style={{color: 'blue'}}>이메일 인증이 완료되었습니다.</div>}
        </td>
    </tr>
}

function Timer({setEmailTimeout, emailTimeout, INTERVAL, MINUTES_IN_MS, setTimeLeft, timeLeft, emailChecked}) {


    useEffect(() => {
        const timer = setInterval(() => {
            setTimeLeft((prevTime) => prevTime - INTERVAL);
        }, INTERVAL);

        if (timeLeft <= 0) {
            clearInterval(timer);
        }

        return () => {
            clearInterval(timer);
        };
    }, [timeLeft]);

    const minutes = String(Math.floor((timeLeft / (1000 * 60)) % 60)).padStart(2, '0');
    const second = String(Math.floor((timeLeft / 1000) % 60)).padStart(2, '0');
    if (emailChecked === true)
        return <span> 인증 완료 </span>
    else if (second === '00' && minutes === '00') {
        if (emailTimeout) {
            setEmailTimeout(false)
        }
        return <span> 인증번호를 재전송 해주세요 </span>
    } else {
        if (!emailTimeout) {
            setEmailTimeout(true)
        }
        return <span> {minutes} : {second}</span>
    }

}
export default EmailCheck