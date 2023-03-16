import { globalCss } from "@stitches/react";

export const GlobalStyles = globalCss({  
  body: {
    backgroundColor: "$default",
    boxSizing: "border-box",
    lineHeight: 1,
    fontFamily: 'Rubik',
  },

  "*": {
    margin: 0,
    padding: 0,
  },

  "h1, h2, h3, p, label, span": {
    fontSize: "100%",
    font: "inherit",
    verticalAlign: "baseline",
  },

  'button': {
    border: 'none',
  },

  "ol, ul": {
    listStyle: "none",
  },

  "main": {
    padding: "6em 4em 0 6em",
  },
});
