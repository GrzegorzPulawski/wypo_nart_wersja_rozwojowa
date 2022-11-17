import axios from "../../axios/axios";
import {Button, Col, Container, Row} from "react-bootstrap";
import classes from "./Zwrot.module.css";
import React from "react";

function Zwrot () {
    const submit = () => {
        let nrWypozyczenie = document.getElementById('input-nrWypozyczenia').value;

        console.log(nrWypozyczenie +" ")

       //   let createZwrot = {
         //     'idWypozyczenie': nrWypozyczenie
          //}


        axios.post('/api/wypozyczenie/return?' ,null, {params:{idWypozyczenie: nrWypozyczenie }})
            .then((response)=>{
                console.log(response)
            })
            .catch((error)=>{
                console.log(error)
            });
    }
    return (
        <div >
            <Container className={classes.Form} >
                <Row>
                    <Col>
                        <label>Nr zdawanego wypożyczenia:</label>
                        <input id={'input-nrWypozyczenia'} placeholder={'Nr'}/>
                    </Col>
                </Row>
                <Row>
                    <Col className={classes.Button} >
                        <Button variant={"light"} onClick={submit}>Zatwierdź zmiany</Button>
                    </Col>
                </Row>
            </Container>
        </div>
    );
}
export default Zwrot;