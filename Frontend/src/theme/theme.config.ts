import { createStitches } from "@stitches/react";

import { GlobalStyles } from "@/theme/global.config";

const stitches = createStitches({
    media: {
        mobile: "(min-width: 320px)",
        tablet: "(min-width: 768px)",
        desktop: "(min-width: 1200px)",
    },
    theme: {
        colors: {
            brand: "#EC5161",
            default: "#F3F4F6",
            background: "#FFFFFF",

            //@Hovers.
            brandHover: "#cf4251",
        },
        shadows: {
            sm: "0 1px 2px 0 rgb(0 0 0 / 0.05)",
            md: "0 1px 3px 0 rgb(0 0 0 / 0.1), 0 1px 2px -1px rgb(0 0 0 / 0.1)",
            lg: "0 4px 6px -1px rgb(0 0 0 / 0.1), 0 2px 4px -2px rgb(0 0 0 / 0.1)"
        },
        radii: {
            sm: '0.25rem',
            md: '0.375rem',
            lg: '0.5rem'
        }
    },

});

GlobalStyles();

export default stitches;
