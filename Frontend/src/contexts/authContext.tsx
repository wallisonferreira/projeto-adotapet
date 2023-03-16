import { createContext } from "react";

import { api } from "@/service/api";

type SignInCredentials = {
    username: string;
    password: string;
}

type AuthContextType = {
    isAuthenticated: boolean;
    signIn: (data: SignInCredentials) => Promise<void>
};

type AuthProviderProps = {
    children?: React.ReactNode;
}

export const AuthContext = createContext({} as AuthContextType);

export function AuthProvider({ children }: AuthProviderProps) {

    const isAuthenticated = false;

    async function signIn({ username, password }: SignInCredentials) {

        const response = await api.post("/api/auth/signin", {
            username,
            password
        });

        console.log(response);
    }
    return (
        <AuthContext.Provider value={{ isAuthenticated, signIn }}>
            {children}
        </AuthContext.Provider>
    );
}
