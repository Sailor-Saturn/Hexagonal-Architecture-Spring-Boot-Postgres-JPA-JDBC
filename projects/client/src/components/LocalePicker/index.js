import React, { useContext } from "react";
import { Context } from "../IntlWrapper";

const LocalePicker = () => {
  const context = useContext(Context);

  const selectLanguage = e => {
    context.selectLanguage(e.target.value);
  };

  return (
    <div className="App">
      <header className="App-header">
        <select value={context.language} onChange={selectLanguage}>
          <option value="pt">PT</option>
          <option value="en">EN</option>
        </select>
      </header>
    </div>
  );
};

export default LocalePicker;
