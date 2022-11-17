import React, {useEffect, useState} from "react";
import {Col, Container, Row,} from "react-bootstrap";
import axios from "../../axios/axios";
import classes from "./KlientList.module.css";
import {Grid} from "@mui/material";

const KlientList = () => {
    const [klientList, setterKlientList] = useState([]);

    useEffect(() => {
        axios.get("/api/klient")
            .then((response) => {
                console.log(response);
                setterKlientList(response.data)
            })
            .catch((error) => {
                console.log(error);
            });
    }, []);
    return (
        <div>
            <Container className={classes.TableHeader}>
                <Row>
                     <Col xs={1}>Id</Col>
                     <Col xs={2}>Nazwisko</Col>
                     <Col xs={2}>Imię</Col>
                     <Col xs={2}>Numer dowodu</Col>
                     <Col xs={2}>Numer telefonu</Col>
                </Row>
            </Container>

            {
                klientList.map(value => {
                        return (

                            <Container className={classes.TableRow}>
                                <Row>
                                    <Col xs={1}>{value.idKlient}</Col>
                                    <Col xs={2}>{value.nazwisko}</Col>
                                    <Col xs={2}>{value.imie}</Col>
                                    <Col xs={2}>{value.nrDowodu}</Col>
                                    <Col xs={2}>{value.nrTelefonu}</Col>
                                </Row>
                            </Container>
                        )
                    }
                )
            }
        </div>
    );
}
export default KlientList;