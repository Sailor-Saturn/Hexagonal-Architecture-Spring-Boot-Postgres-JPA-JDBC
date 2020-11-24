import en from "../lang/en";
import pt from "../lang/pt";

/**
 * Retrieves the language to use and the strings of the text in that language
 * If the language received is not supported, defaults to PT language
 * @param {string} language language to retrieve information from
 */
const getLanguageInformation = language => {
  if (language.startsWith("en")) {
    return {
      language: "en",
      messages: en,
    };
  }

  return {
    language: "pt",
    messages: pt,
  };
};

export default getLanguageInformation;
