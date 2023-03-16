import React, { useContext } from "react";

import * as Dialog from "@radix-ui/react-dialog";

import { Cross2Icon } from "@radix-ui/react-icons";

import {
  Button,
  DialogContent,
  DialogDescription,
  DialogOverlay,
  DialogTitle,
  Fieldset,
  Flex,
  IconButton,
  Input,
  Label,
} from "./styles";
import { AuthContext } from "@/contexts/authContext";

interface IDialogProps {
  children: React.ReactNode;
}

export const DialogAuthComponent: React.FC<IDialogProps> = ({ children }) => {
  const { signIn } = useContext(AuthContext);

  async function handleSignIn() {
    await signIn({
      username: "admin@admin.com",
      password: "admin",
    });
  }

  return (
    <Dialog.Root>
      <Dialog.Trigger asChild>{children}</Dialog.Trigger>
      <Dialog.Portal>
        <DialogOverlay />
        <DialogContent>
          <DialogTitle>Edit profile</DialogTitle>
          <DialogDescription>
            Make changes to your profile here. Click save when you're done.
          </DialogDescription>
          <Fieldset>
            <Label htmlFor="name">Name</Label>
            <Input id="name" defaultValue="Pedro Duarte" />
          </Fieldset>
          <Fieldset>
            <Label htmlFor="username">Username</Label>
            <Input id="username" defaultValue="@peduarte" />
          </Fieldset>
          <Flex css={{ marginTop: 25, justifyContent: "flex-end" }}>
            <Dialog.Close asChild>
              <Button variant="green" onClick={() => handleSignIn()}>
                Save changes
              </Button>
            </Dialog.Close>
          </Flex>
          <Dialog.Close asChild>
            <IconButton aria-label="Close">
              <Cross2Icon />
            </IconButton>
          </Dialog.Close>
        </DialogContent>
      </Dialog.Portal>
    </Dialog.Root>
  );
};
