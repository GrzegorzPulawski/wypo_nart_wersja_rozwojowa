import React from "react";
import classes from "./Form.module.css";
import axios from "../../axios/axios";
import {Button, Col, Container, Row} from "react-bootstrap";

function Form() {
    const submit = () => {
        let nazwa = document.getElementById('input-nazwa').value;
        let rozmiar = document.getElementById('input-rozmiar').value;
        let rodzaj = document.getElementById('input-rodzaj').value;

        console.log(nazwa + " " + rozmiar + " " + rodzaj)

        // JSON który odzwierciedla CreateButyRequest
        let createButy = {
            'nazwaButow': nazwa,
            'rozmiarButow': rozmiar,
             'rodzajButow': rodzaj
        }

        axios.post("/api/buty", createButy)
            .then((response) => {
                console.log(response)
            })
            .catch((error) => {
                console.log(error)
            });
    }

    return (
        <div >
            <Container className={classes.Form}>
            <Row>
            <Col>
                <labelabel className={'form-input-label'}>Nazwa butów:</labelabel>
                <input id={"input-nazwa"} placeholder={'Nazwa'} className={'form-input-field'}/>
            </Col>
            <Col>
                    <label className={'form-input-label'}>Rozmiar butów:</label>
                    <input type={'number  '} id={'input-rozmiar'} placeholder={'Rozmiar'} className={'form-input-field'}/>
            </Col>
            <Col>
                    <label className={'form-input-label'}>Wybierz rodzaj:</label>
                    <select id={'input-rodzaj'} placeholder={'Rodzaj'} className={'form-input-field'}>
                        <option value={"NARCIARSKIE"}>Narciarskie</option>
                        <option value={"SNOWBOARDOWE"}>Snowboardowe</option>
                    </select>
                </Col>
            </Row>

            <Row className={classes.Button}>
                <Button variant={"light"} onClick={submit}>Zatwierdź zmiany</Button>
            </Row>
            </Container>
        </div>
    );
}

export default Form;