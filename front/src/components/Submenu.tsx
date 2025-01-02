import React from 'react';
import { Submenu } from './ItensMenu';

interface SubmenuProps {
    menu: Submenu;
    onClose: () => void; // Função para fechar o submenu
    onMouseEnter: () => void; // Função para manter o submenu aberto
    onMouseLeave: () => void; // Função para fechar o submenu
}

const SubmenuComponent: React.FC<SubmenuProps> = ({ menu, onMouseEnter, onMouseLeave }) => {
    return (
        <div 
            className="submenu w-[35vh] h-[20vh] bg-[#0064F3] text-slate-200"
            onMouseEnter={onMouseEnter} // Aberto quando mouse entrar
            onMouseLeave={onMouseLeave} // Feche quando mouse sair
        >
            <h3 className="text-lg font-semibold">{menu.title}</h3>
            <ul className="list-disc pl-5 ">
                {menu.options.map((option, index) => (
                    <li key={index}>
                        <a href={option.link} className=" hover:underline">
                            {option.name}
                        </a>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default SubmenuComponent;