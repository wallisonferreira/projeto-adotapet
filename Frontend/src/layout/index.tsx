import stitches from "@/theme/theme.config";

import React, { FunctionComponent } from "react";

import { Head } from '@/app/head'
import { Header } from "@/components/ui/header";


interface IProps {
  children?: React.ReactNode;
}

const { styled } = stitches;


export const Layout: React.FC<IProps> = ({ children }) => {
  return (
    <>  
      <Head />
      <Header />
      <main>
        { children }
      </main>

    </>
  );
}