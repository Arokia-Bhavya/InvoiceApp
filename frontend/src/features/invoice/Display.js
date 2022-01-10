import React,{useEffect} from 'react';
import {useDispatch, useSelector} from 'react-redux';

export function Display()
{
    const dispatch = useDispatch()
    useEffect(()=>{
        fetch("http://localhost:8080/enterprise-app/invoice/all")
        .then(response => response.json)
        .then(invoices => dispatch({type:"SET_INVOICES",}))
    },[])
    const invoices = useSelector((s) => s.invoices);

  return(<div><h3>
    {
      props.invoice.vendorName
    }
  </h3></div>);
}

