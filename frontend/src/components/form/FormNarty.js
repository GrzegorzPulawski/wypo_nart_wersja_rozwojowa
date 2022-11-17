import React from 'react';
import axios from "../../axios/axios";
import classes from "./FormNarty.module.css";
import {Button, Col, Container, Row} from "react-bootstrap";

function FormNarty() {
    const submitNarty = () => {
        let nazwa = document.getElementById('input-nazwa').value;
        let dlugosc = document.getElementById('input-dlugosc').value;
        let rodzaj = document.getElementById('input-rodzaj').value;

        console.log(nazwa + " " + dlugosc + " " + rodzaj)

        let createNarty = {
            'nazwaNart': nazwa,
            'dlugoscNart': dlugosc,
            'rodzajNart': rodzaj
        }
        axios.post("/api/narty", createNarty)
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
                <label>Nazwa Nart: </label>
                <input id={'input-nazwa'} placeholder={'Nazwa nart'}/>
            </Col>
            <Col>
                <label>Długość nart: </label>
                <input type={'number'} id={'input-dlugosc'} placeholder={'Długość nart'}/>
            </Col>
            <Col>
                <label>Wybierz rodzaj:</label>
                <select id={'input-rodzaj'}>
                    <option value={'NARTY'}>Narty</option>
                    <option value={"SNOWBOARD"}>Snowboard</option>
                </select>
            </Col>
             </Row>

            <Row className={classes.Button}>
            <Button variant={'light'} onClick={submitNarty}>Zatwierdź zmiany</Button>
           </Row>
           </Container>
        </div>
    );
}
export default FormNarty;