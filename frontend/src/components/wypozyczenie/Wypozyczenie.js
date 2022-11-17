import React from "react";
import axios from "../../axios/axios";
import classes from "../wypozyczenie/Wypozyczenie.module.css";
import {Button, Col, Container, Row} from "react-bootstrap";
import {Link} from "react-router-dom";

function Wypozyczenie() {
    const submit = () => {
       let cenaWypozyczenia = document.getElementById('input-cenaWypozyczenia').value;
       let komplet = document.getElementById('input-komplet').value;
       let klient = document.getElementById('input-klient').value;

       console.log(cenaWypozyczenia +" "+ komplet+ " "+ klient + " ")

       let createWypozyczenie = {
           'cenaWypozyczenia': cenaWypozyczenia,
           'idKlient': klient,
           'idKomplet': komplet
       }
       axios.post('/api/wypozyczenie/rent', createWypozyczenie)
           .then((response)=>{
               console.log(response)
           })
           .catch((error) => {
               console.log(error)
           });
   }
   return(
       <div >
           <Container className={classes.Form} >
               <Row>
               <Col className={classes.FormRow}>
                   <label className={'form-input-label'}>Cena wypożyczenia:</label>
                   <input type={'number'} id={'input-cenaWypozyczenia'} placeholder={'Możesz zmienić cene'} className={'form-input-field'}/>
               </Col>
               <Col className={classes.FormRow}>
                   <label className={'form-input-label'}>ID komplet:</label>
                   <input type={'number'} id={'input-komplet'} placeholder={'Nr kompletu'} className={'form-input-field'}/>
               </Col>
               <Col className={classes.FormRow}>
                   <label className={'form-input-label'}>ID Klient:</label>
                   <input type={'number'} id={'input-klient'} placeholder={'Nr Klienta'} className={'form-input-field'}/>
               </Col>
               </Row>
                <Row>
           <Col className={classes.Button}>
               <Button variant={"light"} onClick={submit}>Zatwierdź zmiany</Button>
           </Col>
               <Col className={classes.Button}>
                   <Link to={"/wypozyczenielist"}>
                       <Button variant={"light"}>Listuj wypożyczenia</Button>
                   </Link>
               </Col>
                    <Col className={classes.Button}>
                        <Link to={"/zwrot-wypozyczenia"}>
                            <Button variant={"light"}>Zwrot wypożyczenia</Button>
                        </Link>
                    </Col>
                </Row>
           </Container>
       </div>
   );
}
export default Wypozyczenie;