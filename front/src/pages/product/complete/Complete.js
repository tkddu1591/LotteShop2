import {useEffect, useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";
import {useSelector} from "react-redux";
import Info from "./Info";
import Alert from "./Alert";
import Message from "./Message";
import Order from "./Order";
import Delivery from "./Delivery";

function Complete() {
    let [completeList, setCompleteList] = useState([]);
    let [completeTotal, setCompleteTotal] = useState([]);
    let member = useSelector((state) => state.member);
    useEffect(() => {
        axios.get('/product/complete/list', {
            params: {
                uid: 'user'
            }
        }).then(res => {
            setCompleteList(res.data)
        }).catch(err => {
            console.log(err)
        })
        axios.get('/product/complete/total', {
            params: {
                uid: 'user'
            }
        }).then(res => {
            setCompleteTotal(res.data)
        }).catch(err => {
            console.log(err)
        })
    }, []);

    let navigate = useNavigate();
    console.log(completeList)
    console.log(completeTotal)
    return <>

        <Message></Message>
        <Info completeTotal={completeTotal} completeList={completeList}></Info>
        <Order completeTotal={completeTotal} member={member}></Order>
        <Delivery member={member} completeTotal={completeTotal}></Delivery>
        <Alert></Alert>

    </>
}

export default Complete