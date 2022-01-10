import React from 'react';
import logo from './logo.svg';
import { Counter } from './features/counter/Counter';
import { Display } from './features/invoice/Display';
import './App.css';

function App() {
  return (
    <div className="App">
      <Display/>
    </div>
  );
}

export default App;
