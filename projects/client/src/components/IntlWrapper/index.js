import React, { useState } from "react";
import { IntlProvider } from "react-intl";
import getLanguageInfo from "../../helpers/getLanguage";
import PropTyopes from "prop-types";

export const Context = React.createContext();

const { language: languageToUse, messages: messagesToUse } = getLanguageInfo(
  window.navigator.language
);

const Wrapper = props => {
  const [language, setLanguage] = useState(languageToUse);
  const [messages, setMessages] = useState(messagesToUse);

  function selectLanguage(newLanguage) {
    const { language, messages } = getLanguageInfo(newLanguage);
    setLanguage(language);
    setMessages(messages);
  }

  return (
    <Context.Provider value={{ language, selectLanguage }}>
      <IntlProvider messages={messages} locale={language}>
        {props.children}
      </IntlProvider>
    </Context.Provider>
  );
};

Wrapper.propTypes = {
  children: PropTyopes.node,
};

Wrapper.defaultProps = {
  children: null,
};

export default Wrapper;
