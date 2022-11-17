import React from "react";
import axios from "../../axios/axios";
import classes from "./KlientForm.module.css";
import {Link} from "react-router-dom";
import {Button, Col, Container, Row} from "react-bootstrap";

function KlientForm () {
    const submit = () => {
        let nazwisko = document.getElementById('input-nazwisko').value;
        let imie = document.getElementById('input-imie').value;
        let nrDowodu = document.getElementById('input-nrDowodu').value;
        let nrTelefonu = document.getElementById('input-nrTelefonu').value;

        console.log(nazwisko +" "+imie + " "+ nrDowodu+" "+nrTelefonu+" ")

        let createKlient = {
            'nazwisko': nazwisko,
            'imie': imie,
            'nrDowodu': nrDowodu,
            'nrTelefonu': nrTelefonu
        }

        axios.post("/api/klient", createKlient)
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
                <label>Nazwisko:</label>
                <input id={'input-nazwisko'} placeholder={'Nazwisko'}/>
            </Col>
            <Col>
                <label>Imię:</label>
                <input id={'input-imie'} placeholder={'Imię'}/>
            </Col>
            <Col>
                <label>Nr dowodu:</label>
                <input id={'input-nrDowodu'} placeholder={'podaj'} size={8}/>
            </Col>
            <Col>
                <label>Nr telefonu:</label>
                <input type={'number'} id={'input-nrTelefonu'} placeholder={'Nr telefonu'} size={10}/>
            </Col>
            </Row>
            <Row>
            <Col className={classes.Button} >
            <Button variant={"light"} onClick={submit}>Zatwierdź zmiany</Button>
            </Col>
            <Col className={classes.Button}>
            <Link to={"/klient-list"}>
                <Button variant={"light"} >Lista Klientów</Button>
            </Link>
            </Col>
            </Row>
            </Container>
        </div>
    );
}
export default KlientForm;