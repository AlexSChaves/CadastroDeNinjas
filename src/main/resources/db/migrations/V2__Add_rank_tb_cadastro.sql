-- Migration para adicionar a coluna rank na tabela de cadastros

ALTER TABLE TB_CADASTRO
ADD COLUMN RANK VARCHAR(255);