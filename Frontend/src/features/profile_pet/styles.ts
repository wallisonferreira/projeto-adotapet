import { styled } from "@stitches/react";

export const Container = styled("div", {
    display: "grid",
    gridTemplateColumns: "1fr 2fr",
});

export const ContainerLeft = styled("div", {
    alignItems: 'center',

});
export const ContainerRigth = styled("div", {
    // backgroundColor: 'blue',
});

export const ContainerRigthOne = styled("div", {
    background: '#FFFFFF',
    boxShadow: '1px 1px 8px 1px rgba(0, 0, 0, 0.25)',
    borderRadius: '8px',
    padding: '15px 55px',
});

export const LeftOne = styled("div", {
    background: '#DFDFDF',
    padding: '15px 55px',
    borderRadius: '30px',
    height: '50px',
    width: '306px',
    display: 'flex',
    alignItems: 'center',
    fontFamily: 'Quicksand',
    marginBottom: '26px'
});

export const Title = styled("p", {
    fontFamily: 'Rubik',
    fontWeight: '600',
    fontSize: '36px',
});

export const Title2 = styled("p", {
    fontFamily: 'Rubik',
    fontWeight: '500',
    fontSize: '24px',
    lineHeight: '28px',
});

export const Text = styled("p", {
    fontFamily: 'Quicksand',
    fontWeight: '700',
    fontSize: '18px',
});

export const Form = styled("form", {
    boxSizing: 'border-box',

    position: 'absolute',
    width: '558px',
    height: '48px',
    left: '726px',
    top: '386px',
    border: '1px solid #EC5161',
    borderRadius: '10px',
});

export const Entrada = styled("input", {
    boxSizing: 'border-box',
    border: '1px solid #EC5161',
    borderRadius: '10px',
    width: '100%',
    height: '48px',
});

export const Entrada2 = styled("input", {
});

export const Divi = styled("div", {
});