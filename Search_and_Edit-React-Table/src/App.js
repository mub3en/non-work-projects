import React, { useState } from "react";
import Container from 'react-bootstrap/Container';
import 'bootstrap/dist/css/bootstrap.min.css';
import TableStructure from "./components/Table/TableStructure";
import FilterComponent from "./FilterComponent";
import { writing_data } from './components/DATA/writing_data';
import { speaking_data } from './components/DATA/speaking_data';
import Banner from "./components/Misc/Banner";
import BannerInput from "./components/Misc/BannerInput";
import TransferCreditInput from "./components/Misc/TransferCreditInput";
import './App.css'


const App = () => {
  const [username, setUserName] = useState('');
  const [transferCredits, setTransferCredits] = useState('');
  const [isBannerInputDisabled, setIsBannerInputDisabled] = useState(false);

  const handleSetUserName = (e) => {
    setUserName(e.target.value);
    setIsBannerInputDisabled(true);
  }

  const handleSetCredits = (e) => {
    setTransferCredits(e.target.value);

  }

  const writingFilter = FilterComponent(writing_data, transferCredits);
  const speakingFilter = FilterComponent(speaking_data, transferCredits);

  return (
    <div className="text-center">
      <div className="container">
        <BannerInput onChangeUserName={handleSetUserName} isDisabled={isBannerInputDisabled} />
        <TransferCreditInput onChangeTransferCredits={handleSetCredits} />
      </div>
      <Container className="mt-4 col-md-12">
        {/* Writing Table */}
        <div >
          <Banner userName={username} />
          <TableStructure data={writingFilter.tableData} onSave={writingFilter.handleSave} />
        </div>

        {/* Speaking Table */}
        <div>
          <Banner userName={username} />
          <TableStructure data={speakingFilter.tableData} onSave={speakingFilter.handleSave} />
        </div>
      </Container>

    </div>
  );
};

export default App;
